package com.example.ylye.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.ylye.entity.Review;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ReviewMapper extends BaseMapper<Review> {
}
