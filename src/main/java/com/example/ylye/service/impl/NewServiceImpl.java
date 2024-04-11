package com.example.ylye.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.ylye.entity.News;
import com.example.ylye.mapper.NewsMapper;
import com.example.ylye.service.NewsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.ylye.utils.Common.MORE_PAGE_SIZE;
import static com.example.ylye.utils.Common.PAGE_SIZE;

@Slf4j
@Service
@RequiredArgsConstructor
public class NewServiceImpl extends ServiceImpl<NewsMapper, News> implements NewsService {
    /**
     * 通过页数来查询page
     * @param page
     * @return
     */
    @Override
    public Page<News> findNewsByPage(Integer page) {
        //通过page来查询不同的页数
        Page<News> p = new Page<>(page,PAGE_SIZE);
        List<News> newsPage = this.baseMapper.selectByPage(page,PAGE_SIZE);
        p.setRecords(newsPage);
        return p;
    }

    @Override
    public List<News> getHot() {
        List<News> list = this.baseMapper.getHot();
        return list;
    }

    @Override
    public List<News> getYl() {
        List<News> list = this.baseMapper.getYl();
        return list;
    }

    @Override
    public List<News> getNew() {
        List<News> list = this.baseMapper.getNew();
        return list;
    }

    @Override
    public Page<News> getNewsByPage(Integer page, Integer type) {
        Page<News> p = new Page<>(page-1,MORE_PAGE_SIZE);
//        List<News> list = this.baseMapper.getNewsByPage(p,page,type);
        LambdaQueryWrapper<News> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(News::getNtype,type);
        Integer size = list(wrapper).size();
        wrapper.last( "limit " + ((page-1) *MORE_PAGE_SIZE) +",15");

        List<News> list = list(wrapper);
        p.setRecords(list);
        p.setTotal(size);
        return p;
    }

    @Override
    public void delByNid(Integer nid) {
        this.baseMapper.removeById(nid);
    }


}
