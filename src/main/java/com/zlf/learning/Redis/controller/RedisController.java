package com.zlf.learning.Redis.controller;

import com.zlf.learning.Redis.dao.User;
import com.zlf.learning.Redis.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @ClassName
 * @Description DOTO
 * @Author zhulinfeng
 * @Date 2019/8/1 19:59
 * @Version 1.0
 */

@RestController
public class RedisController {

    @Autowired
    private RedisService redisService;

    @RequestMapping("/getUser")
    public User  getUser(){
        String name="quellan";
        return redisService.getUser(name);
    }

    @RequestMapping("/setUser")
    public String setUser(){
        User user=new User("aa@qq.com","quellan","123456","朱",new Date().getTime()+"");
        redisService.setUser(user);
        user.setEmail("bb@qq.com");
        redisService.setUserBystringRedisTemplate(user);
        return "添加成功";
    }

    @RequestMapping("/getUserByStringRedisTemplate")
    public String  getUserByStringRedisTemplate(){
        String name="quellan";
        return redisService.getUserBystringRedisTemplate(name);
    }

    @RequestMapping("/setString")
    public String setString(String key ,String value){
        redisService.setString(key,value);
        return "添加成功";
    }
    @RequestMapping("/getString")
    public String setString(String key){
        return redisService.getString(key);
    }


}
