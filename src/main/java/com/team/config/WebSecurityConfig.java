package com.team.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.team.bean.RespBean;
import com.team.common.beans.ResultBean;
import com.team.common.utils.UserUtil;
import com.team.exception.AuthenticationAccessDeniedHandler;
import com.team.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.web.cors.CorsUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * create by yifeng
 */
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserService userService;
    @Autowired
    private CustomMetadataSource metadataSource;
    @Autowired
    private UrlAccessDecisionManager urlAccessDecisionManager;
    @Autowired
    private AuthenticationAccessDeniedHandler accessDeniedHandler;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(new BCryptPasswordEncoder());
    }

    // 注入加密类
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/index.html", "/static/**", "/login_p", "/favicon.ico");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .withObjectPostProcessor(new ObjectPostProcessor<FilterSecurityInterceptor>() {
                    @Override
                    public <O extends FilterSecurityInterceptor> O postProcess(O o) {
                        o.setSecurityMetadataSource(metadataSource);
                        o.setAccessDecisionManager(urlAccessDecisionManager);
                        return o;
                    }
                })
                .and()
                .formLogin().loginPage("/login_p")
                // 自定义登录请求，对应表单中的action
                // 可在postman中发送 post请求 http://localhost:8060/login?username=asdf123&password=123456
                .loginProcessingUrl("/login")
                .usernameParameter("username").passwordParameter("password")
                .failureHandler(new AuthenticationFailureHandler() {
                    @Override
                    public void onAuthenticationFailure(HttpServletRequest req,
                                                        HttpServletResponse resp,
                                                        AuthenticationException e) throws IOException {
                        resp.setContentType("application/json;charset=utf-8");
                        ResultBean resultBean = new ResultBean("LOGIN FAIL");
                        resultBean.setCode(ResultBean.CHECK_FAIL);
                        if (e instanceof BadCredentialsException ||
                                e instanceof UsernameNotFoundException) {
                            resultBean.setCode(-2);
                            resultBean.setMsg("用户名或密码不正确");
                        }
//                        else if (e instanceof LockedException) {
//                            resultBean = RespBean.error("账户被锁定，请联系管理员!");
//                        }
//                        else if (e instanceof CredentialsExpiredException) {
//                            respBean = RespBean.error("密码过期，请联系管理员!");
//                        } else if (e instanceof AccountExpiredException) {
//                            respBean = RespBean.error("账户过期，请联系管理员!");
//                        } else if (e instanceof DisabledException) {
//                            respBean = RespBean.error("账户被禁用，请联系管理员!");
//                        }
                        else {
                            resultBean.setCode(-99);
                            resultBean.setMsg("未知异常");
                        }
                        ObjectMapper om = new ObjectMapper();
                        PrintWriter out = resp.getWriter();
                        out.write(om.writeValueAsString(resultBean));
                        out.flush();
                        out.close();
                    }
                })
                .successHandler(new AuthenticationSuccessHandler() {
                    @Override
                    public void onAuthenticationSuccess(HttpServletRequest req,
                                                        HttpServletResponse resp,
                                                        Authentication auth) throws IOException {
//                        resp.setStatus(400);
                        resp.setContentType("application/json;charset=utf-8");
                        ResultBean<Object> resultBean = new ResultBean<Object>(UserUtil.getCurrentUser());
                        resultBean.setCode(0);
                        ObjectMapper om = new ObjectMapper();
                        PrintWriter out = resp.getWriter();
                        out.write(om.writeValueAsString(resultBean));
                        out.flush();
                        out.close();
                    }
                })
                .permitAll()
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessHandler(new LogoutSuccessHandler() {
                    @Override
                    public void onLogoutSuccess(HttpServletRequest req, HttpServletResponse resp, Authentication authentication) throws IOException, ServletException {
                        resp.setContentType("application/json;charset=utf-8");
                        ObjectMapper om = new ObjectMapper();
                        PrintWriter out = resp.getWriter();
                        out.write(om.writeValueAsString(new ResultBean<String>("注销成功")));
                        out.flush();
                        out.close();
                    }
                })
                .permitAll()
                .and().csrf().disable();

    }
}


/*

http.authorizeRequests()
                .withObjectPostProcessor(new ObjectPostProcessor<FilterSecurityInterceptor>() {
                    @Override
                    public <O extends FilterSecurityInterceptor> O postProcess(O object) {
                        object.setSecurityMetadataSource(metadataSource);
                        object.setAccessDecisionManager(urlAccessDecisionManager);
                        return object;
                    }
                })
            .and()
            .formLogin()
            .loginPage("/sys-signIn.html")
            .loginProcessingUrl("/authentication/form")
            // 登陆失败处理器
            .failureHandler(new AuthenticationFailureHandler() {
            @Override
            public void onAuthenticationFailure(HttpServletRequest req,
                                                HttpServletResponse resp,
                                                AuthenticationException e) throws IOException {
                logger.info("登陆失败");
                resp.setContentType("application/json;charset=utf-8");
                // 因为拦截器在Aspect之前拦截，故这里aop不会运行
                ResultBean<String> resultBean = null;

                resp.setStatus(401);
                ObjectMapper om = new ObjectMapper();
                PrintWriter out = resp.getWriter();
                out.write(om.writeValueAsString(resultBean));
                out.flush();
                out.close();
                }
            })
            // 登陆成功处理器
            .successHandler(new AuthenticationSuccessHandler() {
                @Override
                public void onAuthenticationSuccess(HttpServletRequest req,
                                                    HttpServletResponse resp,
                                                    Authentication auth) throws IOException {
                    logger.info("登陆成功");
                    resp.setContentType("application/json;charset=utf-8");
                    ObjectMapper om = new ObjectMapper();
                    PrintWriter out = resp.getWriter();
                    out.write(om.writeValueAsString(new ResultBean<String>("登陆成功")));
                    out.flush();
                    out.close();
                }
            })
            .permitAll()
                // from表单请求的action
//            .loginProcessingUrl("/authentication/form")
            .and()
            .authorizeRequests()
//            // 当访问对应url的时候不需要身份认证
            .antMatchers("/sys-signIn.html")
            .permitAll()
            //.anyRequest()
            //.authenticated()
            .and()
            .csrf()
            .disable()
            .exceptionHandling().accessDeniedHandler(accessDeniedHandler);


 */


