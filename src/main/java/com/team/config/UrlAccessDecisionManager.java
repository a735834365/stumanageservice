package com.team.config;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Iterator;

/**
 *
 * create by yifeng
 */
@Component
public class UrlAccessDecisionManager implements AccessDecisionManager {

    Logger logger = LoggerFactory.getLogger(UrlAccessDecisionManager.class);

    // 当前用户是否有权限访问对于的页面
    @Override
    public void decide(Authentication auth, Object object, Collection<ConfigAttribute> cas) throws AccessDeniedException, InsufficientAuthenticationException {
        Iterator<ConfigAttribute> iterator = cas.iterator();
        while (iterator.hasNext()) {
            ConfigAttribute ca = iterator.next();
            //当前请求需要的权限
            String needRole = ca.getAttribute();
            logger.info("UrlAccessDecisionManager：Required permissions" + needRole);
            if ("ROLE_LOGIN".equals(needRole)) {
                logger.info("UrlAccessDecisionManager->decide:auth instaceof AnonymousAuthenticationToken  " + (auth instanceof AnonymousAuthenticationToken));
                if (auth instanceof AnonymousAuthenticationToken) {
                    throw new BadCredentialsException("未登录");
                } else
                    return;
            }
            //当前用户所具有的权限
            Collection<? extends GrantedAuthority> authorities = auth.getAuthorities();
            logger.info("UrlAccessDecisionManager：当前用户所具有的权限为" + authorities);
            for (GrantedAuthority authority : authorities) {
                if (authority.getAuthority().equals(needRole)) {
                    return;
                }
            }
        }
        throw new AccessDeniedException("权限不足!");
    }

    @Override
    public boolean supports(ConfigAttribute attribute) {
        return true;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }
}
