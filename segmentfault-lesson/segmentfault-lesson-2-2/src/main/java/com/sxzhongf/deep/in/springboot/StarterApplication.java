package com.sxzhongf.deep.in.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * StarterApplication for TODO
 *
 * @author <a href="mailto:magicianisaac@gmail.com">Isaac.Zhang</a>
 * @see
 * @since 2019/5/20
 */

@SpringBootApplication
@ServletComponentScan(
        basePackages = {
                "com.sxzhongf.deep.in.springboot.servlet"
                ,"com.sxzhongf.deep.in.springboot.filter"
                ,"com.sxzhongf.deep.in.springboot.listener"
        }
)
public class StarterApplication {
    public static void main(String[] args) {
        SpringApplication.run(StarterApplication.class, args);
    }
}