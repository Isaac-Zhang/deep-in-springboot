package com.sxzhongf.deep.in.springboot.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;

/**
 * MyServletRequestListener for TODO
 *
 * @author <a href="mailto:magicianisaac@gmail.com">Isaac.Zhang</a>
 * @see
 * @since 2019/5/20
 */
@WebListener
public class MyServletRequestListener implements ServletRequestListener {
    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        //获取事件的 source，如sre.getSource()
        //因其返回的是Object，因此使用getServletRequest()获取source，等同于上述方法
        HttpServletRequest request = (HttpServletRequest)sre.getServletRequest();

        ServletContext servletContext = request.getServletContext();
        servletContext.log("request was destroyed.");
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        //获取事件的 source，如sre.getSource()
        //因其返回的是Object，因此使用getServletRequest()获取source，等同于上述方法
        HttpServletRequest request = (HttpServletRequest)sre.getServletRequest();

        ServletContext servletContext = request.getServletContext();
        servletContext.log("request was initialized.");
    }
}
