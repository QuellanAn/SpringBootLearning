package com.zlf.learning.Redis.dao;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @ClassName User
 * @Description DOTO
 * @Author zhulinfeng
 * @Date 2019/8/1 20:23
 * @Version 1.0
 */

@Getter
@Setter
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long id;
    private String userName;
    private String password;
    private String email;
    private String nickname;
    private String regTime;

    public User(String email, String nickname, String password, String userName, String regTime) {
        super();
        this.email = email;
        this.nickname = nickname;
        this.password = password;
        this.userName = userName;
        this.regTime = regTime;
    }
}
