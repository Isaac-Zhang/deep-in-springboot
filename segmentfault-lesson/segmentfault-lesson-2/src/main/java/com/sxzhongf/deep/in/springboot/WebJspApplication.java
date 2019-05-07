package com.sxzhongf.deep.in.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * Jsp Web Application starter
 *
 * @author <a href="mailto:magicianisaac@gmail.com">Isaac.Zhang</a>
 * @see
 * @since
 */
@SpringBootApplication
public class WebJspApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(WebJspApplication.class, args);
    }

    /**
     * Spring Boot 默认不支持Servlet容器
     * 需要显示实现
     * @param builder
     * @return
     */
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(WebJspApplication.class);
    }
}
