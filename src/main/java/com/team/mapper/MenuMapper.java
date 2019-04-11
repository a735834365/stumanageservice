package com.team.mapper;


import com.team.bean.Menu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by sang on 2017/12/28.
 */
@Mapper
public interface MenuMapper {
    List<Menu> getAllMenu();

    List<Menu> getMenusByUId(Long Hrid);

    List<Menu> menuTree();

    List<Long> getMenusByRid(Long rid);
}
