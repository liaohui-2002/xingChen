package com.liaohui.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.liaohui.domain.Post;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @auther Mr.Liao
 * @date 2022/10/31 17:39
 */
@Mapper
public interface PostMapper extends BaseMapper<Post> {

    @Select("select * from post where user_id = #{user_id} AND post_type = #{post_type} order by create_time desc limit 1")
    public Post getByTypeAndUser(@Param("user_id") Long userId,@Param("post_type") Integer postType);

    void updateById(Post post, Long id);
}
