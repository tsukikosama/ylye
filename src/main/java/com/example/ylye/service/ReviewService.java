package com.example.ylye.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.ylye.entity.Review;

import java.util.List;
import java.util.Set;

public interface ReviewService extends IService<Review> {



    String addRevice(Review review);


    List<Review> listreview();

    List<Review> getReviewById(Integer id);
}
