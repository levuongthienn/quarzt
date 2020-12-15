package vn.vnpay.commons.http;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class HttpClientBean {

    private static final Logger LOGGER = LogManager.getLogger(HttpClientBean.class);

    private static HttpClientBean ourInstance = new HttpClientBean();

    public static HttpClientBean getInstance() {
        return ourInstance;
    }

    private OkHttpClient okClient = null;

    private HttpClientBean() {
        init();
    }

    private OkHttpClient init() {
        try {
            OkHttpClient clientOrig = new OkHttpClient.Builder()
                    .retryOnConnectionFailure(true)
                    .cache(new Cache(new File("/"), 2097152)).build();
            okClient = clientOrig
                    .newBuilder()
                    .connectTimeout(120, TimeUnit.SECONDS)
                    .readTimeout(120, TimeUnit.SECONDS)
                    .writeTimeout(120, TimeUnit.SECONDS)
                    .build();
        } catch (Exception ex) {
            LOGGER.error("OTTClient have ex: {}.", ex);
        }
        return okClient;
    }

    public OkHttpClient getOkClient() {
        return okClient;
    }
}
