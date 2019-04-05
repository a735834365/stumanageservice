package com.team.service;

import com.team.bean.Role;
import javafx.scene.Node;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * 登陆在这里处理
 * create by yifeng
 */
@Service
@Transactional
public class UserService implements UserDetailsService {

    private Logger logger = LoggerFactory.getLogger(UserService.class);

    // 解密
    @Autowired
    private PasswordEncoder passwordEncoder;

    // 通过连接数据库获取用户权限和用户信息
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        logger.info("表单登陆用户名： " + username);
        String password = passwordEncoder.encode("123456");
//        if (user == null) {
//            throw new UsernameNotFoundException("用户名不正确");
//        }
//        logger.info("数据库密码 ：" + password);
        return new User(username, password,
                true, true,true,true,
                AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
    }

 /*   public User getHrById(Long hrId) {
        return user;
    }*/
}
