package com.zlf.learning.Redis.controller;

import com.zlf.learning.Redis.dao.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @ClassName IndexController
 * @Description DOTO
 * @Author zhulinfeng
 * @Date 2019/8/1 21:26
 * @Version 1.0
 */

@Controller
public class IndexController {

    @RequestMapping("/index")
    public String index(Model model) {
        List<User> users = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            User user=new User("1186154608@qq.com","quellan","123456","朱",new Date().getTime()+"");
            user.setId(Long.parseLong(i+""));
            users.add(user);
        }
        model.addAttribute("users", users);
        model.addAttribute("user", users.get(0));
        return "index";
    }

}
