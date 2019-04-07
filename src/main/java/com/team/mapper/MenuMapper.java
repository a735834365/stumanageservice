package com.team.mapper;

import com.team.bean.Menu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * create by yifeng
 */
@Mapper
public interface MenuMapper {

    List<Menu> getAllMenu();

}
