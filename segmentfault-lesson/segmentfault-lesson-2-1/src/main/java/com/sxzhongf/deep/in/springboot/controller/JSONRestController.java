package com.sxzhongf.deep.in.springboot.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * JSONRestController for TODO
 *
 * @author <a href="mailto:magicianisaac@gmail.com">Isaac.Zhang</a>
 * @see
 * @since 2019/5/14
 */
@RestController
public class JSONRestController {

    /**
     * <!--
     * 引入之后，我们的JSONRestController#getUser 返回到界面上会以XML的形式
     * 如不引入，会显示JSON格式
     * -->
     * <dependency>
     * <groupId>com.fasterxml.jackson.dataformat</groupId>
     * <artifactId>jackson-dataformat-xml</artifactId>
     * </dependency>
     */
    @GetMapping(path = "/rest/xml/user", produces = MediaType.APPLICATION_XML_VALUE) //只接受application/xml
//    @GetMapping(path = "/rest/xml/user")
    public User getUser() {
        User user = new User();
        user.setName("XML Isaac");
        user.setAge(30);
        return user;
    }

    /**
     * 强制返回JSON格式
     */
    @GetMapping(path = "/rest/json/user", produces = {MediaType.APPLICATION_JSON_VALUE})
    public User getJsonUser() {
        User user = new User();
        user.setName("JSON Isaac");
        user.setAge(30);
        return user;
    }

    /**
     * 强制接受JSON格式的请求，返回JSON格式
     */
    @GetMapping(path = "/rest/json/user",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public User getJsonTypeUser() {
        User user = new User();
        user.setName("request JSON Isaac");
        user.setAge(30);
        return user;
    }
}
