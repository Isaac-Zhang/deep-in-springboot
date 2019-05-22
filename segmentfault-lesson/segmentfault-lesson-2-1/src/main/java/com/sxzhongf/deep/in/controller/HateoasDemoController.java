package com.sxzhongf.deep.in.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

/**
 * HateoasDemo for study
 * how to use Hypermedia As The Engine Of Application State
 * 1. Entity 继承 {@link org.springframework.hateoas.ResourceSupport}
 * 2. EntityObj.add(...)
 *
 * @author <a href="mailto:magicianisaac@gmail.com">Isaac.Zhang</a>
 * @see
 * @since 2019/5/15
 */
@RestController
@RequestMapping("/rest")
public class HateoasDemoController {

    /**
     * 在DEMO演示的时候，使用Bean注入的方式，
     * 可以保证服务器端，当前对象的状态保存一致
     * 必须在请求中使用setUserName("ZhangPan")修改了Name,那么当前Bean中的名称就会被更新掉
     */
    @Bean
    private User currentUser() {
        User user = new User();
        user.setName("Isaac");
        user.setAge(30);
        user.add(linkTo(methodOn(HateoasDemoController.class).setUserName(user.getName())).withSelfRel());
        user.add(linkTo(methodOn(HateoasDemoController.class).setUserAge(user.getAge())).withSelfRel());
        return user;
    }

    @Autowired
    @Qualifier("currentUser")
    private User user;

    @GetMapping(path = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
    public User user() {
//        user.add(linkTo(methodOn(HateoasDemoController.class).setUserName(user.getName())).withSelfRel());
//        user.add(linkTo(methodOn(HateoasDemoController.class).setUserAge(user.getAge())).withSelfRel());
        return user;
    }

    @GetMapping("/user/set_name")
    public User setUserName(@RequestParam String name) {
        user.setName(name);
        return user;
    }

    @PostMapping("/user/set_age")
    public User setUserAge(@RequestParam int age) {
        user.setAge(age);
        return user;
    }


}
