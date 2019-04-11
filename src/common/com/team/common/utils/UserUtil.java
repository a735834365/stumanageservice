package com.team.common.utils;

import com.team.bean.User;
import com.team.common.exception.UnloginException;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Before;
import org.slf4j.MDC;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * create by yifeng
 */
public class UserUtil {

    private final static ThreadLocal<String> tluser = new ThreadLocal<>();

    public static final String KEY_USER = "user";

    // 获得被验证过用户的权限
    public static User getCurrentUser() {
        return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

    public static void setUser(String userid) {
        tluser.set(userid);

        // 将用户信息放到log4j
        MDC.put(KEY_USER, userid);
    }

    public static String getUserIfLogin() {
        return tluser.get();
    }

    /**
     * 如果没有登陆会抛出异常
     * @return
     */
    public static String getUser() {
        String user = tluser.get();

        if (user == null) {
            throw new UnloginException();
        }

        return user;
    }

    public static void clearAllUserInfo() {
        tluser.remove();

        MDC.remove(KEY_USER);
    }

}
