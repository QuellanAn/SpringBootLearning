package com.zlf.learning.Redis.service;

import com.zlf.learning.Redis.dao.User;
import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

/**
 * @ClassName RedisService
 * @Description DOTO
 * @Author zhulinfeng
 * @Date 2019/8/1 20:19
 * @Version 1.0
 */
@Service
@Slf4j
public class RedisService {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    public boolean setUser(User user){
        ValueOperations ops=redisTemplate.opsForValue();
        ops.set(user.getNickname(),user);
        return true;
    }

    public User getUser(String name){
        ValueOperations ops=redisTemplate.opsForValue();
        return (User)ops.get(name);
    }

    public boolean setUserBystringRedisTemplate(User user){
        ValueOperations ops=stringRedisTemplate.opsForValue();
        ops.set(user.getNickname(),JSONObject.fromObject(user).toString());
        return true;
    }

    public String getUserBystringRedisTemplate(String name){
        ValueOperations ops=stringRedisTemplate.opsForValue();
        return JSONObject.fromObject(ops.get(name)).toString();
    }

    public boolean setString(String key,String value){
        ValueOperations ops=stringRedisTemplate.opsForValue();
        ops.set(key,value);
        return true;
    }
    public String getString(String key){
        ValueOperations ops=stringRedisTemplate.opsForValue();
        return (String)ops.get(key);
    }
}
