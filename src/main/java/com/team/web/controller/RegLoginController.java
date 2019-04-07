package com.team.web.controller;

import com.team.common.beans.ResultBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * create by yifeng
 */
@RestController
public class RegLoginController {
    // 登陆处理
    @RequestMapping("/login_p")
    public ResultBean<String> login() {
        ResultBean resultBean = new ResultBean("尚未登录，请登录");
        resultBean.setCode(ResultBean.NO_LOGIN);
        return resultBean;
    }
}
