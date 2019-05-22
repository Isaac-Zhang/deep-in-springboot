package com.sxzhongf.deep.in.spring.boot;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

/**
 * MyServletSpringboot for TODO
 *
 * @author <a href="mailto:magicianisaac@gmail.com">Isaac.Zhang</a>
 * @see
 * @since 2019/5/20
 */
public class MyServletSpringboot extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Writer writer = response.getWriter();
        ServletContext servletContext = request.getServletContext();
        servletContext.log("myServletSpringBoot doGet ...");
        writer.write("<html><body>Hello,World from MyServletSpringboot</body></html>");

    }
}
