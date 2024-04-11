package com.example.ylye.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.ylye.entity.Orders;
import com.example.ylye.pojo.UserOrder;

import java.util.List;

public interface OrderService extends IService<Orders> {
    String createOrderByUid(Integer uid,Integer pid);

    List<Orders> findOrderByUid(Integer uid);

    List<UserOrder> getAll();
}
