package com.team.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.team.bean.Menu;
import com.team.bean.Role;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.oauth2.provider.client.Jackson2ArrayOrStringDeserializer;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import sun.rmi.runtime.Log;

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

    AntPathMatcher antPathMatcher = new AntPathMatcher();

    // 当前请求页面需要什么权限
    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        // 获取请求地址
        String requestUrl = ((FilterInvocation)object).getRequestUrl();

        logger.info("CustomMetadataSource:当前请求的页面：" + requestUrl);

        // 如果是登陆页，则直接返回，无需处理
        if("/sys-signIn.html".equals(requestUrl) || "/login".equals(requestUrl)) {
            return null;
        }
        // 这里获取对应页面所需要的权限
        List<Menu> allMenu = initMenu(new ArrayList(3));
        for (Menu menu : allMenu) {
            if (antPathMatcher.match(menu.getUrl(), requestUrl)
                    &&menu.getRoles().size()>0) {
                List<Role> roles = menu.getRoles();
                int size = roles.size();
                String[] values = new String[size];
                // role权限可能不止一个，所以需要做多个处理
                for (int i = 0; i < size; i++) {
                    values[i] = roles.get(i).getName();
                    System.out.println(values+" ");
                }
                return SecurityConfig.createList(values);
            }
        }
        // 没有匹配的资源做登陆处理
        return SecurityConfig.createList("ROLE_LOGIN");
    }

    // 模拟数据
    private List<Menu> initMenu(List allMenu) {
        List<Role> roles = new ArrayList<>();
        Role role = new Role();
        role.setId(1L);
        role.setName("ROLE_manager");
        Role role2 = new Role();
        role.setId(2L);
        role.setName("ROLE_admin");
        Role role3 = new Role();
        role.setId(3L);
        role.setName("ROLE_test1");
        roles.add(role);
        roles.add(role2);
        roles.add(role3);
        Menu menu = new Menu();
        menu.setRoles(roles);
        // 增加对应的页面
        menu.setUrl("/demo");
        Menu menu2 = new Menu();
        menu2.setRoles(roles);
        // 增加对应的页面
        menu2.setUrl("/cocohello");
        allMenu.add(menu);
        allMenu.add(menu2);
        return allMenu;
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
