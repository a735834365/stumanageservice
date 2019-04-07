package com.team.service;

import com.team.bean.Menu;
import com.team.mapper.MenuMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * create by yifeng
 */
@Transactional
@Service
public class MenuService {

    @Resource
    MenuMapper menuMapper;

    public List<Menu> getAllMenu() {
        return menuMapper.getAllMenu();
    }

}
