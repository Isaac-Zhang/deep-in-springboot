package com.sxzhongf.deep.in.jsp;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.Map;

/**
 * Application Controller
 *
 * @author <a href="mailto:magicianisaac@gmail.com">Isaac.Zhang</a>
 * @see Controller
 * @since
 */

@Controller
public class WelcomeController {

    @Value("${application.message:Hello Isaac}")
    private String message = "hello jsp";

    /**
     *
     * Test jsp
     *
     * @author <a href="mailto:magicianisaac@gmail.com">Isaac.Zhang</a>
     * @since 2019/5/6 9:52 AM
     * @param model
     * @return java.lang.String
     *
     */
    @GetMapping("/welcome")
    public String welcome(Map<String,Object> model){
        model.put("time",new Date());
        model.put("message",this.message);
        return "welcome";
    }

    @GetMapping("/")
    public String index(Map<String,Object> model){
        model.put("time",new Date());
        model.put("message",this.message);
        return "index";
    }

    @RequestMapping("foo")
    public String foo(Map<String,Object> model){
        throw new RuntimeException("foo");
    }

}
