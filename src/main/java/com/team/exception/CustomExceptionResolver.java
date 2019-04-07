package com.team.exception;

import com.team.common.beans.ResultBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.transform.Result;
import java.util.HashMap;
import java.util.Map;

/**
 * security 异常统一处理
 * create by yifeng
 */
public class CustomExceptionResolver implements HandlerExceptionResolver {
    Logger logger = LoggerFactory.getLogger(CustomExceptionResolver.class);
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse response, Object o, Exception e) {
        logger.error("CustomExceptionResolver: " + e);
        ModelAndView mv = new ModelAndView(new MappingJackson2JsonView());
        ResultBean<String> resultBean = new ResultBean<>();
        if (e instanceof DataIntegrityViolationException) {
            resultBean.setCode(ResultBean.CHECK_FAIL);
            resultBean.setData("该角色尚有关联的资源或用户，删除失败!");
        }  else {
            resultBean.setCode(ResultBean.CHECK_FAIL);
            resultBean.setData("LOGIN FAIL!");
        }
        mv.addObject(resultBean);
        return mv;
    }
}
