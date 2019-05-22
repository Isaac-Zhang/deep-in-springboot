package com.sxzhongf.deep.in.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

/**
 * MyServlet for TODO
 *
 * @author <a href="mailto:magicianisaac@gmail.com">Isaac.Zhang</a>
 * @see
 * @since 2019/5/20
 */
@WebServlet(
        name = "myServlet",
        urlPatterns = "/myservlet",
        initParams = {
                //place_holder方式
                @WebInitParam(name = "zp", value = "isaac")
        }
)
public class MyServlet extends HttpServlet {

    private String value;

    @Override
    public void init(ServletConfig servletConfig) throws ServletException{
        value = servletConfig.getInitParameter("zp");

//        super.init(servletConfig); //1
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        Writer writer = response.getWriter();
//        getServletContext(); //想要正常获取到ServletContext 需要配上代码1
        ServletContext servletContext = request.getServletContext();
        servletContext.log("myServlet doGet ...");
        writer.write("<html><body>Hello,World. zp is "+value+"</body></html>");
    }
}
