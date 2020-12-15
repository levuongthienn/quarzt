package vn.vnpay.commons.api.config.commons;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;
import org.apache.logging.log4j.util.Strings;
import vn.vnpay.commons.configuration.ConfigurableProcessor;
import vn.vnpay.commons.utils.PropertiesUtils;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.util.Properties;

public class BaseConfig {

    protected static Logger LOGGER;

    public static String folderConfig;

    protected static void mapConfig(String configFile, Class<?> clazz) throws IOException {
        Properties props = PropertiesUtils.load(folderConfig + configFile);
        ConfigurableProcessor.process(clazz, props);
    }

    protected static void logger() throws IOException {
        if (Strings.isEmpty(folderConfig))
            folderConfig = new File(".").getCanonicalPath() + "/config/";
        String evn = System.getenv("MMS_ENV");
        folderConfig += (Strings.isEmpty(evn) ? "" : evn);
        URI source = new File(folderConfig + "log4j2.xml").toURI();
        Configurator.initialize("contextLog4J", null, source);
        LOGGER = LogManager.getLogger(BaseConfig.class);
        LOGGER.info("Init log4j2 success and load all config from :{}", folderConfig);
    }

}
