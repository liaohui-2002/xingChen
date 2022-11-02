package com.liaohui.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.liaohui.domain.Menu;

import java.util.List;

/**
 * @author Mr.lh
 * @date 2022/11/2 23:04
 */
public interface MenuMapper extends BaseMapper<Menu> {
    /**
     * 通过userid 获取权限
     * @param id
     * @return
     */
    List<String> selectPermsByUserId(Long id);
}