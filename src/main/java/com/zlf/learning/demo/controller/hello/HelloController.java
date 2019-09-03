package com.zlf.learning.demo.controller.hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName Hello
 * @Description demo
 * @Author zhulinfeng
 * @Date 2019/7/24 10:22
 * @Version 1.0
 */

@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String hello(){
        return "hello Spring boot 2.0";
    }
}
