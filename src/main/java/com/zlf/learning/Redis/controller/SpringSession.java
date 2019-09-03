package com.zlf.learning.Redis.controller;

import org.springframework.beans.factory.annotation.Value;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @ClassName SpringSession
 * @Description DOTO
 * @Author zhulinfeng
 * @Date 2019/8/3 14:38
 * @Version 1.0
 */

@RestController
public class SpringSession {

    @Value("${server.port}")
    Integer port;

    @RequestMapping("/setSession")
    public String setSession(HttpSession session){
        session.setAttribute("key","quellanAn");
        return String.valueOf(port);
    }

    @RequestMapping("/getSession")
    public String getSession(HttpSession  session){
        return session.getAttribute("key")+":"+port;
    }
}
