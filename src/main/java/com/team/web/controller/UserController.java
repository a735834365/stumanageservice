package com.team.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import com.team.common.beans.ResultBean;
import com.team.common.utils.UserUtil;

import javax.servlet.http.HttpSession;

/**
 * create by yifeng
 */
@Controller
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    public ResultBean<String> login(HttpSession session, String username) {
        logger.info("login user:" + username);

        session.setAttribute(UserUtil.KEY_USER, username);

        return new ResultBean<String>(username);
    }

}
