package com.xzj;

import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

/**
 * Created by charles on 2017/5/22.
 */
@SpringBootApplication
@ImportResource(value = {
        "classpath:dubbo/*.xml"
})
//@ComponentScan({"com.xzj","com.github.charlesvhe.springcloud.practice.consumer"})
public class ConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate(){
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .protocols(Arrays.asList(Protocol.H2_PRIOR_KNOWLEDGE))
                .build();

        return new RestTemplate(new OkHttp3ClientHttpRequestFactory(okHttpClient));
    }
}
