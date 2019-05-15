package com.sxzhongf.deep.in.springboot.controller;

import lombok.Data;
import org.springframework.hateoas.ResourceSupport;

/**
 * User for TODO
 *
 * @author <a href="mailto:magicianisaac@gmail.com">Isaac.Zhang</a>
 * @see
 * @since 2019/5/14
 */
@Data
public class User extends ResourceSupport {
    private String name;
    private int age;
}
