package com.example.ylye.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.ylye.entity.Product;
import com.example.ylye.entity.Project;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ProductMapper extends BaseMapper<Product> {
}
