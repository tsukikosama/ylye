package com.example.ylye.controller;


import cn.hutool.core.date.DateUtil;
import com.example.ylye.common.Result;
import com.example.ylye.entity.Review;
import com.example.ylye.service.ReviewService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/review")
public class ReviewController {



    @Autowired
    private ReviewService reviewService;



    @PostMapping("/addreview")
    public Result addReview(@RequestBody Review review){
//        System.out.println(review);
        String msg = reviewService.addRevice(review);
        return Result.ok(msg);
    }
    @PostMapping("delreview")
    public Result delReview(@RequestParam("rid") Integer rid){
        boolean success = reviewService.removeById(rid);
        if(!success){
            return Result.fail("删除失败请稍后再试");
        }
        return Result.ok("删除成功");
    }
    @ApiOperation("查询全部评论 ")
    @GetMapping("/findall")
    public Result findAllReview(){
        List<Review> list = reviewService.listreview();
        return Result.ok(list);
    }

    @GetMapping("/all")
    @ApiOperation("查询全部回复包括评论")
    public Result findAll(){
        List<Review> list = reviewService.list();
        return Result.ok(list);
    }
    @PostMapping("/backreview")
    @ApiOperation("后台回复接口")
    public Result backReview(@RequestBody Review review){
        review.setCtime(DateUtil.now());
        reviewService.save(review);
        return Result.ok("回复成功");
    }

    @ApiOperation("根据项目查评论")
    @GetMapping("/{xid}")
    public Result getReviewById(@PathVariable("xid") Integer xid){
       List<Review> list =  reviewService.getReviewById(xid);
       return Result.ok(list);
    }

}
