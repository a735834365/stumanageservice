package com.team.config;

import com.team.bean.Menu;
import com.team.bean.Role;
import com.team.service.MenuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 通过当前的请求地址，获取该地址需要的用户角色
 * create by yifeng
 */
@Component
public class CustomMetadataSource implements FilterInvocationSecurityMetadataSource {

    private Logger logger = LoggerFactory.getLogger(CustomMetadataSource.class);

    private AntPathMatcher antPathMatcher = new AntPathMatcher();

    @Autowired
    private MenuService menuService;

    // 当前请求页面需要什么权限
    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        // 获取请求地址
        String requestUrl = ((FilterInvocation)object).getRequestUrl();

        logger.info("CustomMetadataSource:当前请求的页面：" + requestUrl);
//
//        // 如果是登陆页，则直接返回，无需处理
//        if("/login_p".equals(requestUrl)) {
//            return null;
//        }
        // 这里获取对应页面所需要的权限
        List<Menu> allMenu = menuService.getAllMenu();
//        logger.info("CustomMetadataSource.getAttributes->allMenu: " + allMenu);
        for (Menu menu : allMenu) {
            if (antPathMatcher.match(menu.getUrl(), requestUrl)
                    &&menu.getRoles().size()>0) {
                List<Role> roles = menu.getRoles();
                int size = roles.size();
                String[] values = new String[size];
                // role权限可能不止一个，所以需要做多个处理
                for (int i = 0; i < size; i++) {
                    values[i] = roles.get(i).getName();
                }
                return SecurityConfig.createList(values);
            }
        }
        // 没有匹配的资源做登陆处理
        return SecurityConfig.createList("ROLE_LOGIN");
    }


    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return FilterInvocation.class.isAssignableFrom(clazz);
    }
}
