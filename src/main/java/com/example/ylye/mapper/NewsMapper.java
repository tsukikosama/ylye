package com.example.ylye.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.ylye.entity.News;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface NewsMapper extends BaseMapper<News> {
    List<News> selectByPage(Integer current, Integer pagesize);

    List<News> getHot();

    List<News> getYl();

    List<News> getNew();

    List<News> getNewsByPage(Page<News> pg,Integer page, Integer type);

    void removeById(Integer nid);

}
