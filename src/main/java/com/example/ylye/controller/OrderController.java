package com.example.ylye.controller;

import com.example.ylye.common.Result;
import com.example.ylye.entity.Orders;
import com.example.ylye.pojo.UserOrder;
import com.example.ylye.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
@Api(tags = "订单沟里接口")
public class OrderController {

    private final OrderService orderService;

    @ApiOperation("通过用户id创建订单")
    @GetMapping("/addorder")
    public Result createOrder(@RequestParam("userid")Integer uid,@RequestParam("pid")Integer pid){
        String oid = orderService.createOrderByUid(uid, pid);
        return Result.ok(oid);
    }

    @ApiOperation(("通过id查询全部的订单"))
    @GetMapping("/{id}")
    public Result findOrderByUid(@PathVariable("id")Integer uid){
        List<Orders> list = orderService.findOrderByUid(uid);
        return Result.ok(list);

    }

    @ApiOperation("查询所有订单")
    @GetMapping()
    public Result getAll(){
        List<UserOrder> list = orderService.getAll();
        return Result.ok(list);
    }
}
