package com.sxzhongf.deep.in.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * RestDemoController for TODO
 *
 * @author <a href="mailto:magicianisaac@gmail.com">Isaac.Zhang</a>
 * @see Controller
 * @see ResponseBody
 * @see RestController
 * @since 2019/5/13
 */
//@Controller
@RestController
public class HtmlRestDemoController {

    /**
     * @see GetMapping
     * @see PostMapping
     * 上述两个注解出现的原因就是为了解决同一个action，在URL是get,URL2是Post这种场景
     */
//    @RequestMapping(value = {"/html/demo","/html/demo2"}, method = RequestMethod.GET)
    @GetMapping(value = "/html/demo")
    @PostMapping(value = "/html/demo2")
//    @GetMapping(path = "/html/demo3")
    @ResponseBody
    public String htmlCode() {
        return "<html><body>hello,GetMapping & PostMapping</body></html>";
    }

    @RequestMapping("/html/demo1")
    @ResponseBody
    public String html() {
        return "<html><body>hello,RequestMapping</body></html>";
    }

    /**
     * 演示 {@link PathVariable}
     * eg:
     * http://localhost:8080/html/demo/1
     * Warning: {placeHolder} 占位符的名称必须和参数placeHolder名称保持一致！！！
     */
    @GetMapping(path = "/html/demo/{placeHolder}")
    public String htmlPathVariable(@PathVariable String placeHolder) {
        return "<html><body>hello," + placeHolder + "</body></html>";
    }

    /**
     * 演示{@link RequestParam}
     * eg:
     * http://localhost:8080/html/demo/value?bbbb=hi1
     */
    @GetMapping(path = "/html/demo/value")
    public String htmlRequestParam(@RequestParam(value = "bbbb", required = false, defaultValue = "empty") String param) {
        return "<html><body>Request Param value : " + param + "</body></html>";
    }

    /**
     * 演示{@link HttpServletRequest}获取参数
     * eg:
     * http://localhost:8080/html/demo/servletrule?p=111&param2=2222
     * RequestParam 的另一个好处是 可以进行类型转换
     * eg:
     * http://localhost:8080/html/demo/servletrule?p=111&age=dss
     * 报错如下
     * Failed to convert value of type 'java.lang.String' to required type 'java.lang.Integer';
     * nested exception is java.lang.NumberFormatException: For input string: "dss"
     */
    @GetMapping(path = "/html/demo/servletrule")
    public String htmlServletRule(@RequestParam(value = "p", required = false, defaultValue = "empty") String param,
                                  HttpServletRequest request,
                                  @RequestParam(value = "age", required = false, defaultValue = "0") Integer age) {
        String param2 = request.getParameter("param2");
        return "<html><body>ServletRule Param value : " + param2 + ", age :" + age + "</body></html>";
    }

    /**
     * 演示{@link RequestHeader}获取参数
     * eg:
     * http://localhost:8080/html/demo/header
     * HttpHeader Param Accept :
     * text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*\/*;q=0.8,application/signed-exchange;v=b3
     */
    @GetMapping(path = "/html/demo/header")
    public String htmlHeader(@RequestHeader(value = "Accept") String acceptHeader) {
        return "<html><body>HttpHeader Param Accept : " + acceptHeader + "</body></html>";
    }

    @RequestMapping(path = "/html/response/entity")
    public ResponseEntity htmlResponseEntity() {
        HttpHeaders httpHeader = new HttpHeaders();
        httpHeader.put("myHeader", Arrays.asList("myHeaderValue"));
        ResponseEntity responseEntity = new ResponseEntity("<html><body>hello,responsebody</body></html>",
                httpHeader, HttpStatus.OK);
        return responseEntity;
    }

}
