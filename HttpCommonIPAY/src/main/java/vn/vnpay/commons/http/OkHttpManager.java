package vn.vnpay.commons.http;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;
import org.apache.logging.log4j.util.Strings;
import vn.vnpay.commons.http.bean.IntegrateBean;
import vn.vnpay.commons.http.bean.ResCode;
import vn.vnpay.commons.http.utils.HttpUtils;

import java.lang.reflect.Type;
import java.util.UUID;

public class OkHttpManager {

    private static final Logger LOGGER = LogManager.getLogger(OkHttpManager.class);

    private static final String jsonType = "application/json";

    private static final MediaType mediaType = MediaType.parse(jsonType);

    private static OkHttpManager ourInstance = new OkHttpManager();

    public static OkHttpManager getInstance() {
        return ourInstance;
    }

    private static final String tokenKey = "token";

    private OkHttpManager() {
    }

    public String post(String data, String url) {
        try {
            LOGGER.info("Begin post data: {} , to Url: {}.", data, url);
            RequestBody body = RequestBody.create(MediaType.parse("text/plain"), data);

            String token = ThreadContext.get(tokenKey);
            if (Strings.isEmpty(token)) {
                token = UUID.randomUUID().toString();
            }

            Request request = new Request.Builder()
                    .url(url)
                    .post(body)
//                    .addHeader("Authorization", "admin")
                    .addHeader("content-type", "text/plain")
                    .addHeader("cache-control", "no-cache")
                    .addHeader(tokenKey, token)
                    .build();
            OkHttpClient okClient = HttpClientBean.getInstance().getOkClient();
            if (null == okClient) {
                LOGGER.info("OkClient is null.");
                return HttpUtils.responseBuilder(ResCode.FAIL);
            }
            Response response = okClient.newCall(request).execute();
            if (null == response || response.code() >= 500) {
                return HttpUtils.responseBuilder(ResCode.TIME_OUT);
            }
            String responseString = new String(response.body().bytes(),
                    "UTF-8");
            if (Strings.isEmpty(responseString)) {
                return HttpUtils.responseBuilder(ResCode.TIME_OUT);
            }
            LOGGER.info("Response from server have data: {}", responseString);
            return responseString;
        } catch (Exception ex) {
            System.out.println(ex);
            return HttpUtils.detectException(ex);
        }
    }

    public String post(Object data, String url) {
        try {
            LOGGER.info("Begin post data: {} , to Url: {}.", data, url);
            RequestBody body = RequestBody.create(MediaType.parse("text/plain"), HttpUtils.GSON.toJson(data));

            String token = ThreadContext.get(tokenKey);
            if (Strings.isEmpty(token)) {
                token = UUID.randomUUID().toString();
            }

            Request request = new Request.Builder()
                    .url(url)
                    .post(body)
//                    .addHeader("Authorization", "admin")
                    .addHeader("content-type", "text/plain")
                    .addHeader("cache-control", "no-cache")
                    .addHeader(tokenKey, token)
                    .build();
            OkHttpClient okClient = HttpClientBean.getInstance().getOkClient();
            if (null == okClient) {
                LOGGER.info("OkClient is null.");
                return HttpUtils.responseBuilder(ResCode.FAIL);
            }
            Response response = okClient.newCall(request).execute();
            if (null == response || response.code() >= 500) {
                return HttpUtils.responseBuilder(ResCode.TIME_OUT);
            }
            String responseString = new String(response.body().bytes(),
                    "UTF-8");
            if (Strings.isEmpty(responseString)) {
                return HttpUtils.responseBuilder(ResCode.TIME_OUT);
            }
            LOGGER.info("Response from server have data: {}", responseString);
            return responseString;
        } catch (Exception ex) {
            System.out.println(ex);
            return HttpUtils.detectException(ex);
        }
    }

    public Object post(Object data, String url, final Class<?> rawClass){
        String responseString = post(data, url);
        Object objOut = HttpUtils.GSON.fromJson(responseString, rawClass);
        return objOut;
    }

    public String postJson(String data, String url) {
        try {
            LOGGER.info("Begin post data: {} , to Url: {}.", data, url);
            RequestBody body = RequestBody.create(mediaType, data);

            String token = ThreadContext.get(tokenKey);
            if (Strings.isEmpty(token)) {
                token = UUID.randomUUID().toString();
            }
            Request request = new Request.Builder()
                    .url(url)
                    .post(body)
                    .addHeader("Authorization", "admin")
                    .addHeader("content-type", jsonType)
                    .addHeader("cache-control", "no-cache")
                    .addHeader(tokenKey, token)
                    .build();
            OkHttpClient okClient = HttpClientBean.getInstance().getOkClient();
            if (null == okClient) {
                LOGGER.info("OkClient is null.");
                return HttpUtils.responseBuilder(ResCode.FAIL);
            }
            Response response = okClient.newCall(request).execute();
            if (null == response || response.code() >= 500) {
                return HttpUtils.responseBuilder(ResCode.TIME_OUT);
            }
            String responseString = new String(response.body().bytes(),
                    "UTF-8");
            if (Strings.isEmpty(responseString)) {
                return HttpUtils.responseBuilder(ResCode.TIME_OUT);
            }
            LOGGER.info("Response from server have data: {}", responseString);
            return responseString;
        } catch (Exception ex) {
            return HttpUtils.detectException(ex);
        }
    }

    public <T> IntegrateBean postJson(T obj, String url, final Class<?> rawClass) {
        try {
            String data = HttpUtils.GSON.toJson(obj);
            LOGGER.info("Begin post data: {} , to Url: {}.", data, url);
            RequestBody body = RequestBody.create(mediaType, data);
            String token = ThreadContext.get(tokenKey);
            if (Strings.isEmpty(token)) {
                token = UUID.randomUUID().toString();
            }
            Request request = new Request.Builder()
                    .url(url)
                    .post(body)
                    .addHeader("Authorization", "admin")
                    .addHeader("content-type", "application/json")
                    .addHeader("cache-control", "no-cache")
                    .addHeader(tokenKey, token)
                    .build();
            OkHttpClient okClient = HttpClientBean.getInstance().getOkClient();
            if (null == okClient) {
                LOGGER.info("OkClient is null.");
                return HttpUtils.responseBuilderObj(ResCode.FAIL);
            }
            Response response = okClient.newCall(request).execute();
            if (null == response || response.code() >= 500) {
                return HttpUtils.responseBuilderObj(ResCode.TIME_OUT);
            }
            String responseString = new String(response.body().bytes(), "UTF-8");
            if (Strings.isEmpty(responseString)) {
                return HttpUtils.responseBuilderObj(ResCode.TIME_OUT);
            }
            LOGGER.info("Response from server have data: {}", responseString);

            Type responseType = HttpUtils.getType(IntegrateBean.class, rawClass);
            IntegrateBean<T> objOut = HttpUtils.GSON.fromJson(responseString, responseType);
            return objOut;
        } catch (Exception ex) {
            LOGGER.info("Call Api have exception: {}", ex);
            return HttpUtils.responseBuilderObj(ResCode.EXCEPTION);
        }
    }


    public Object postWithRawClass(Object obj, String url, final Class<?> rawClass) {
        try {
            String data = HttpUtils.GSON.toJson(obj);
            LOGGER.info("Begin post data: {} , to Url: {}.", data, url);
            RequestBody body = RequestBody.create(mediaType, data);
            String token = ThreadContext.get(tokenKey);
            if (Strings.isEmpty(token)) {
                token = UUID.randomUUID().toString();
            }
            Request request = new Request.Builder()
                    .url(url)
                    .post(body)
                    .addHeader("Authorization", "admin")
                    .addHeader("content-type", "application/json")
                    .addHeader("cache-control", "no-cache")
                    .addHeader(tokenKey, token)
                    .build();
            OkHttpClient okClient = HttpClientBean.getInstance().getOkClient();
            if (null == okClient) {
                LOGGER.info("OkClient is null.");
                return HttpUtils.responseBuilderObj(ResCode.FAIL);
            }
            Response response = okClient.newCall(request).execute();
            if (null == response || response.code() >= 500) {
                return HttpUtils.responseBuilderObj(ResCode.TIME_OUT);
            }
            String responseString = new String(response.body().bytes(),
                    "UTF-8");
            if (Strings.isEmpty(responseString)) {
                return HttpUtils.responseBuilderObj(ResCode.TIME_OUT);
            }
            LOGGER.info("Response from server have data: {}", responseString);
            Object objOut = HttpUtils.GSON.fromJson(responseString, rawClass);
            return objOut;
        } catch (Exception ex) {
            LOGGER.info("Call Api have exception: {}", ex);
            return HttpUtils.responseBuilderObj(ResCode.EXCEPTION);
        }
    }

    public Object postWithTypeReponse(Object obj, String url, Type responseType) {
        /*Type responseType = new TypeToken<IntegrateBean<Data>>() {
        }.getType();*/
        try {
            String data = HttpUtils.GSON.toJson(obj);
            LOGGER.info("Begin post data: {} , to Url: {}.", data, url);
            RequestBody body = RequestBody.create(mediaType, data);
            String token = ThreadContext.get(tokenKey);
            if (Strings.isEmpty(token)) {
                token = UUID.randomUUID().toString();
            }
            Request request = new Request.Builder()
                    .url(url)
                    .post(body)
                    .addHeader("Authorization", "admin")
                    .addHeader("content-type", "application/json")
                    .addHeader("cache-control", "no-cache")
                    .addHeader(tokenKey, token)
                    .build();
            OkHttpClient okClient = HttpClientBean.getInstance().getOkClient();
            if (null == okClient) {
                LOGGER.info("OkClient is null.");
                return HttpUtils.responseBuilderObj(ResCode.FAIL);
            }
            Response response = okClient.newCall(request).execute();
            if (null == response || response.code() >= 500) {
                return HttpUtils.responseBuilderObj(ResCode.TIME_OUT);
            }
            String responseString = new String(response.body().bytes(),
                    "UTF-8");
            if (Strings.isEmpty(responseString)) {
                return HttpUtils.responseBuilderObj(ResCode.TIME_OUT);
            }
            LOGGER.info("Response from server have data: {}", responseString);

            Object objOut = HttpUtils.GSON.fromJson(responseString, responseType);
            return objOut;
        } catch (Exception ex) {
            return HttpUtils.responseBuilderObj(ResCode.EXCEPTION);
        }
    }
}
