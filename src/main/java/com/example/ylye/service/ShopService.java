package com.example.ylye.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.ylye.entity.Shop;

import java.util.List;

public interface ShopService extends IService<Shop> {
    List<Shop> getFood();
    List<Shop> getHappy();
}
