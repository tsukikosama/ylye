package com.example.ylye.service.impl;

import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.ylye.entity.Review;
import com.example.ylye.entity.Shop;
import com.example.ylye.entity.User;
import com.example.ylye.mapper.ReviewMapper;
import com.example.ylye.mapper.ShopMapper;
import com.example.ylye.mapper.UserMapper;
import com.example.ylye.service.ReviewService;
import com.example.ylye.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ReviewServiceImpl extends ServiceImpl<ReviewMapper, Review>  implements ReviewService {

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper mapper;






    @Override
    public String  addRevice(Review review) {
        review.setCtime(DateUtil.date().toString());
        boolean flag = this.save(review);
        return "回复成功";
    }

    @Override
    public List<Review> listreview() {
        //查询全部的首评论
        LambdaQueryWrapper<Review> wrapper = new LambdaQueryWrapper<Review>();
        wrapper.eq(Review::getReply,0);

        //全部的父评论
        List<Review> list = this.list(wrapper);
        //获取全部的评论 查看他们是否有回复
//        List<Integer> ids = new ArrayList<>();
        wrapper.clear();
        //存储所有的子评论
        List<Review> replys = new ArrayList<>();
        for(Review r : list){
            wrapper.eq(Review::getRid,r.getId());
            replys = list(wrapper);
            r.setReplays(replys);
            wrapper.clear();
        }
        System.out.println(list);
        return list;

    }

    @Override
    public List<Review> getReviewById(Integer id) {
        LambdaQueryWrapper<Review> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Review::getXid,id);
        List<Review> list = list(wrapper);
        wrapper.clear();
        //存储所有的子评论
        List<Review> replys = new ArrayList<>();
        for(Review r : list){
            wrapper.eq(Review::getRid,r.getId());
            replys = list(wrapper);
            r.setReplays(replys);
            wrapper.clear();
        }
        return list;
    }


}
