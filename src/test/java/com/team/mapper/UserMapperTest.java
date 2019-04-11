package com.team.mapper;

import com.team.StumanageApplicationTest;
import com.team.bean.Menu;
import com.team.bean.Role;
import com.team.bean.User;
import org.junit.Test;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.annotation.Rollback;

import java.util.List;

import javax.annotation.Resource;

/**
 * create by yifeng
 */
@EnableAutoConfiguration
public class UserMapperTest extends StumanageApplicationTest {

    @Resource
    UserMapper userMapper;
    @Resource
    MenuMapper menuMapper;

    PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Test
    public void passwordEncode() {
        String password = passwordEncoder.encode("123");
        System.out.println(password);
    }
    @Test
    public void getUserAndRoles() {
       User user = userMapper.findUserByUserName("test1");
       System.out.println(user.getUsername()+"----------------");
       List<Role> roles = user.getRoles();
       for(Role role:roles) {
    	   System.out.println(role.getName());
       }
       System.out.println("++++++++++++++++");
    }

    @Test
    public void getAllMenu() {
        List<Menu> menus = menuMapper.getAllMenu();
        Menu menu = menus.get(0);
        System.out.println(menu.getUrl());
    }

    @Test
    @Rollback
    public void test() {
        User user = new User();
        user.setUsername("tj666");
        user.setUsername("jojo1");
        //user.setPassword("");
        user.setPassword("$2a$10$QwHSZnf8QsJYtqUAXyDEmuV3X5ry.XtyIs1xlKCWaW2HbXIecaXLe");
        int i = userMapper.addUser(user);
        System.out.println(i+"---------");
    }

    @Test
    public void testFindUserById() {
//        user.setPassword("$2a$10$QwHSZnf8QsJYtqUAXyDEmuV3X5ry.XtyIs1xlKCWaW2HbXIecaXLe");
        User user = userMapper.findUserByUserName("test1");
        System.out.println(user.getUsername());
    }

}
