package vn.vnpay.commons.api.manager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.DefaultServlet;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.jboss.resteasy.plugins.server.servlet.HttpServletDispatcher;
import vn.vnpay.commons.api.config.ApiConfig;
import vn.vnpay.commons.api.config.Constants;
import vn.vnpay.commons.api.filter.ApiFilter;
import vn.vnpay.commons.api.filter.XSSFilter;
import vn.vnpay.commons.token.filter.TokenFilter;
import vn.vnpay.commons.token.filter.mc.MCTokenFilter;

import javax.servlet.DispatcherType;
import java.util.EnumSet;

public class BaseMain {
    public static Logger LOGGER = LogManager.getLogger(BaseMain.class);
    private static Class<?> classApi;
    public static Server server = null;

    public BaseMain(Class<?>... classApi) {
        BaseMain.classApi = classApi[0];
    }

    public void executeServer() throws Exception {
        server = new Server(ApiConfig.PORT);
        // Setup the basic Application "context" at "/".
        // This is also known as the handler tree (in Jetty speak).
        final ServletContextHandler context = new ServletContextHandler(server, ApiConfig.CONTEXT_ROOT);

        // Setup RESTEasy's HttpServletDispatcher at "/api/*".
        final ServletHolder restEasyServlet = new ServletHolder(new HttpServletDispatcher());
        restEasyServlet.setInitParameter("resteasy.servlet.mapping.prefix", ApiConfig.APPLICATION_PATH);
        restEasyServlet.setInitParameter("javax.ws.rs.Application", classApi.getName());
        restEasyServlet.setInitParameter("jersey.config.beanValidation.enableOutputValidationErrorEntity.server", "true");
        restEasyServlet.setInitParameter("jersey.config.server.provider.packages", "vn.vnpay.api");

        context.addServlet(restEasyServlet, ApiConfig.APPLICATION_PATH + "/*");

        // Setup the DefaultServlet at "/".
        final ServletHolder defaultServlet = new ServletHolder(new DefaultServlet());
        context.addServlet(defaultServlet, ApiConfig.CONTEXT_ROOT);

        //Filter add
        context.addFilter(ApiFilter.class, ApiConfig.APPLICATION_PATH + "/*", EnumSet.of(DispatcherType.REQUEST));
        context.addFilter(XSSFilter.class, ApiConfig.APPLICATION_PATH + "/*", EnumSet.of(DispatcherType.REQUEST));
        if (Constants.MMS.equals(ApiConfig.SOURCE)) {
            LOGGER.info("Project authenticate MMS source.");
            context.addFilter(TokenFilter.class, ApiConfig.APPLICATION_PATH + "/*", EnumSet.of(DispatcherType.REQUEST));
        } else if (Constants.MC.equals(ApiConfig.SOURCE)) {
            LOGGER.info("Project authenticate MC source.");
            context.addFilter(MCTokenFilter.class, ApiConfig.APPLICATION_PATH + "/*", EnumSet.of(DispatcherType.REQUEST));
        } else {
            LOGGER.info("Project other.");
        }
        // Set the path to our static (Swagger UI) resources
        String resourceBasePath = BaseMain.class.getResource("/swagger-ui").toExternalForm();
        context.setResourceBase(resourceBasePath);
        context.setWelcomeFiles(new String[]{"index.html"});

        LOGGER.info("Try your swagger with Url: http://" + BaseApplication.getAdd() + ":" + ApiConfig.PORT);
        server.start();
        server.join();
    }

    public static void stopServer() {
        try {
            LOGGER.info("Shutdown server.");
            server.stop();
            LOGGER.info("Stop server Success.");
        } catch (Exception e) {
            LOGGER.error("Stop server have exception: {}", e);
        }
    }
}
