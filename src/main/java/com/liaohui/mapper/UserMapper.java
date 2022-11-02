package com.liaohui.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.liaohui.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author liaohui
 * @date 2022/10/30 16:04
 */
@Mapper
public interface UserMapper  extends BaseMapper<User> {
    @Select("select * from user where username = #{username}")
    public User selectByUsername(@Param("username") String username);
}
