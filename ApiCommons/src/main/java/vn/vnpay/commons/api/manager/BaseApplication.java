package vn.vnpay.commons.api.manager;

import io.swagger.jaxrs.config.BeanConfig;
import vn.vnpay.commons.api.config.ApiConfig;

import javax.ws.rs.core.Application;
import java.net.InetAddress;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class BaseApplication extends Application {

    private HashSet<Object> singletons = new HashSet<Object>();
    private Class<?>[] lsClass;

    public BaseApplication(Class<?>... classApi) {
        lsClass = classApi;
        configureSwagger();
    }

    @Override
    public Set<Class<?>> getClasses() {
        HashSet<Class<?>> set = new HashSet<Class<?>>();
        set.add(io.swagger.jaxrs.listing.ApiListingResource.class);
        set.add(io.swagger.jaxrs.listing.SwaggerSerializers.class);
        set.addAll(Arrays.asList(lsClass));
        return set;
    }

    @Override
    public Set<Object> getSingletons() {
        return singletons;
    }

    private void configureSwagger() {
        BeanConfig beanConfig = new BeanConfig();
        beanConfig.setVersion(ApiConfig.VERSION);
        beanConfig.setSchemes(new String[]{ApiConfig.SCHEMES});
        beanConfig.setHost(getAdd() + ":" + ApiConfig.PORT);
        beanConfig.setBasePath(ApiConfig.APPLICATION_PATH);
        beanConfig.setTitle(ApiConfig.TITLE);
        beanConfig.setDescription(ApiConfig.DESCRIPTION);
        beanConfig.setResourcePackage(lsClass[0].getPackage().getName());
        beanConfig.setContact("Nguyễn Viết Hưng - Phòng Dịch Vụ Giá Trị Gia Tăng");
        beanConfig.setLicense("Jetty Server Base");
        beanConfig.setScan(true);
    }

    public static String getAdd() {
        String add;
        try {
            InetAddress inetAddress = InetAddress.getLocalHost();
            add = inetAddress.getHostAddress();
        } catch (Exception e) {
            add = "localhost";
        }
        return add;
    }
}
