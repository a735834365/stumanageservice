package com.team.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import com.team.common.beans.ResultBean;

import javax.servlet.http.HttpSession;

/**
 * create by yifeng
 */
@RestController
public class HomeController {

    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    @RequestMapping(value = "/test", method =  RequestMethod.GET)
    @ResponseBody
    public ResultBean<String> test(HttpSession session, String username) {
        logger.info("test user: " + username);

//        session.setAttribute();
        return new ResultBean<String>(username);
    }


}
