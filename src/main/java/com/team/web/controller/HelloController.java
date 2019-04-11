package com.team.web.controller;

import com.team.bean.Menu;
import com.team.common.beans.ResultBean;
import com.team.service.MenuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 欢迎
 * create by yifeng
 */
@RestController
public class HelloController {

    @Autowired
    private MenuService menuService;

    private static Logger logger = LoggerFactory.getLogger(HelloController.class);

    @GetMapping("/cocohello")
    public String hello() {
//        logger.info("你好骚啊");
        List<Menu> list = menuService.getAllMenu();
        return "Hello student" + list.toString();
    }

}
