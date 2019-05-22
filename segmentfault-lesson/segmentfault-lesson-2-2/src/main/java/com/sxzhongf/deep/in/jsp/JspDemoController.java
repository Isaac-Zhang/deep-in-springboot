package com.sxzhongf.deep.in.jsp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * JspDemoController for TODO
 *
 * @author <a href="mailto:magicianisaac@gmail.com">Isaac.Zhang</a>
 * @see
 * @since 2019/5/22
 */
@Controller
public class JspDemoController {

    @RequestMapping("/index")
    public String index(Model model) {
        model.addAttribute("message", "Isaac");
        return "index";
    }
}
