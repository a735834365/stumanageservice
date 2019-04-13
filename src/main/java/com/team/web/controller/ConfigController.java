package com.team.web.controller;

import com.team.bean.Menu;
import com.team.bean.ResultBean;
import com.team.bean.User;
import com.team.common.utils.UserUtil;
import com.team.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 登录即可访问
 * create by yifeng
 */
@RestController
@RequestMapping("/config")
public class ConfigController {
    @Autowired
    MenuService menuService;

    @RequestMapping("/sysmenu")
    public ResultBean<List> sysmenu() {
        return new ResultBean<List>(menuService.getMenuByUserId());
    }

    public User currentUser() {
        return UserUtil.getCurrentUser();
    }
}
