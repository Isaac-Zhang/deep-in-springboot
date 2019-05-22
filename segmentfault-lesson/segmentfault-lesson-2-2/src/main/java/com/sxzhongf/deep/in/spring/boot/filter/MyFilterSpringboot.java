package com.sxzhongf.deep.in.spring.boot.filter;

import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * MyFilter for TODO
 *
 * @author <a href="mailto:magicianisaac@gmail.com">Isaac.Zhang</a>
 * @see
 * @since 2019/5/20
 */
public class MyFilterSpringboot extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
//        ServletContext servletContext = request.getServletContext();
//        //或者 servletContext = getServletContext();
//
//        String requestURI = request.getRequestURI();
//        servletContext.log(requestURI + " is filtered.");

        //演示动态获取Request
        doSomething();
        filterChain.doFilter(request, response);
    }

    /**
     * 如果没有传递Request对象，如何获取Request
     */
    private void doSomething() {
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) requestAttributes;
        HttpServletRequest request = servletRequestAttributes.getRequest();

        ServletContext servletContext = request.getServletContext();
        String requestURI = request.getRequestURI();
        servletContext.log(requestURI + " is filtered from dosomething.");
    }
}
