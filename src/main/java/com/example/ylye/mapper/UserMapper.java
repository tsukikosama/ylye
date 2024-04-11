package com.example.ylye.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.ylye.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper extends BaseMapper<User> {
    List<User> selectUserByName(@Param("username") String username);

    User login(@Param("username")String username , @Param("password")String password);

    @Select("SELECT cc_blog.uid from cc_blog\n" +
            "INNER JOIN cc_user on cc_user.uid = cc_blog.uid \n" +
            "INNER JOIN cc_review on cc_review.bid = cc_blog.bid  where cc_review.bid = #{bid} limit 1;\n" +
            "\n")
    int selectUserByBid(@Param("bid") Integer bid);

    List<User> getUserByPage(Integer curr);
}
