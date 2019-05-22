package com.sxzhongf.deep.in;

import com.sxzhongf.deep.in.listener.MyServletRequestListener;
import com.sxzhongf.deep.in.spring.boot.MyServletSpringboot;
import com.sxzhongf.deep.in.spring.boot.filter.MyFilterSpringboot;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import javax.servlet.DispatcherType;

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
                "com.sxzhongf.deep.in.servlet"
                , "com.sxzhongf.deep.in.filter"
                , "com.sxzhongf.deep.in.listener"
                , "com.sxzhongf.deep.in"
        }
)
public class StarterApplication extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(StarterApplication.class, args);
    }

    @Bean
    public static ServletRegistrationBean servletRegistrationBean() {
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean();
        servletRegistrationBean.setName("myServletSpringBoot");
        servletRegistrationBean.setServlet(new MyServletSpringboot());
        servletRegistrationBean.addUrlMappings("/myservletspringboot");
        return servletRegistrationBean;
    }

    @Bean
    public static FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();

        filterRegistrationBean.setFilter(new MyFilterSpringboot());
        filterRegistrationBean.addServletNames("myServletSpringBoot");
        filterRegistrationBean.setDispatcherTypes(DispatcherType.REQUEST, DispatcherType.FORWARD, DispatcherType.INCLUDE);

        return filterRegistrationBean;
    }

    @Bean
    public static ServletListenerRegistrationBean servletListenerRegistrationBean() {
        ServletListenerRegistrationBean servletListenerRegistrationBean = new ServletListenerRegistrationBean();

        servletListenerRegistrationBean.setListener(new MyServletRequestListener());
        return servletListenerRegistrationBean;
    }

    /**
     * 设置jsp需要配置的builder source
     * @param builder
     * @return
     */
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        builder.sources(StarterApplication.class);
        return builder;
    }
}