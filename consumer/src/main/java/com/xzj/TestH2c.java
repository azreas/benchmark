package com.xzj;

import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.Arrays;

/**
 * @author xzj
 * @Date 2019/06/27.
 */
@Slf4j
public class TestH2c {
    public static void main(String[] args) throws Exception {
        testH2C();
//        testH2();
//        String url = "https://127.0.0.1:18080/user";
//        Request request = new Request.Builder().url(url).build();
//        OkHttpClient client = HttpClientUtils.getTLSOKHttp();
//        sendRequest(client, request);
    }

    public static void testH2C() throws Exception {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .protocols(Arrays.asList(Protocol.H2_PRIOR_KNOWLEDGE))
                .build();

        Request request = new Request.Builder()
                .url("http://127.0.0.1:5080/user")
                .build();
        Response response = okHttpClient.newCall(request).execute();
        System.out.println(response.protocol());
        System.out.println(response.body().string());

    }

    static void testH2() throws IOException {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .protocols(Arrays.asList(Protocol.HTTP_1_1,Protocol.HTTP_2))
                .build();
        Request request = new Request.Builder()
                .url("https://127.0.0.1:18080/user")
                .build();
        Response response = okHttpClient.newCall(request).execute();
        System.out.println(response.protocol());
        System.out.println(response.body().string());
    }


    private static String sendRequest(OkHttpClient client, Request request) {
        String result = null;
        String protocolName = null;
        try {
            Response response = client.newCall(request).execute();
            if (response != null) {
                protocolName = response.protocol().name();
                result = response.body().string();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        log.info("测试app的http协议：{}", protocolName);
        return result + ": " + protocolName;
    }
}
