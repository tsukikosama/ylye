package com.example.ylye.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.ylye.entity.News;

import java.util.List;

public interface NewsService extends IService<News> {
    Page<News> findNewsByPage(Integer page);

    List<News> getHot();

    List<News> getYl();

    List<News> getNew();

    Page<News> getNewsByPage(Integer page, Integer type);

    void delByNid(Integer nid);
}
