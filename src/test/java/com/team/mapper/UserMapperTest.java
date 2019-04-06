package com.team.mapper;

import com.team.StumanageApplication;
import com.team.StumanageApplicationTest;
import com.team.bean.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.annotation.Rollback;

import javax.annotation.Resource;

/**
 * create by yifeng
 */
public class UserMapperTest extends StumanageApplicationTest {

    @Resource
    UserMapper userMapper;

    PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    // 生成密码
    @Test
    public void passwordEncode() {
        String password = passwordEncoder.encode("123");
        System.out.println(password);
    }

    @Test
    @Rollback
    public void test() {
        User user = new User();
        user.setUsername("tj666");
        user.setName("jojo");
        user.setPassword("$2a$10$QwHSZnf8QsJYtqUAXyDEmuV3X5ry.XtyIs1xlKCWaW2HbXIecaXLe");
        userMapper.addUser(user);
    }

    @Test
    public void testFindUserById() {
//        user.setPassword("$2a$10$QwHSZnf8QsJYtqUAXyDEmuV3X5ry.XtyIs1xlKCWaW2HbXIecaXLe");
        User user = userMapper.findUserByUserName("asdf123");
    }

}
