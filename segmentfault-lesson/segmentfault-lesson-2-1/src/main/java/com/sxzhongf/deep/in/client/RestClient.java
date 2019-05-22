package com.sxzhongf.deep.in.client;

import com.sxzhongf.deep.in.controller.User;
import org.springframework.web.client.RestTemplate;

/**
 * RestClient demo
 * RestTemplate 访问目标资源的时候，它可以通过序列化实现
 * @author <a href="mailto:magicianisaac@gmail.com">Isaac.Zhang</a>
 * @see RestTemplate
 * @since 2019/5/15
 */
public class RestClient {

    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();

        String content = restTemplate.getForObject("http://localhost:8080/rest/user", String.class);
        System.out.println("isaac : " + content);

        User user = restTemplate.getForObject("http://localhost:8080/rest/user", User.class);
        System.out.println("isaac serializable : " + user);

        User user2 = restTemplate.getForObject("http://localhost:8080/rest/xml/user", User.class);
        System.out.println("isaac xml : " + user2);
    }
}
