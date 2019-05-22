package com.sxzhongf.deep.in.client;

import com.sxzhongf.deep.in.controller.User;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * HttpIntegrateRestTemplateDemo for TODO
 *
 * @author <a href="mailto:magicianisaac@gmail.com">Isaac.Zhang</a>
 * @see
 * @since 2019/5/15
 */
public class HttpIntegrateRestTemplateDemo {

    public static void main(String[] args) {
        HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
        HttpClient httpClient = httpClientBuilder.build();
        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory(httpClient);

        RestTemplate restTemplate = new RestTemplate(factory);

        User user = restTemplate.getForObject("http://localhost:8080/rest/user", User.class);
        System.out.println("isaac serializable : " + user);
    }
}
