package com.example.ylye.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.ylye.entity.Shop;
import com.example.ylye.mapper.ShopMapper;
import com.example.ylye.service.ShopService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ShopServiceImpl extends ServiceImpl<ShopMapper, Shop> implements ShopService {

    @Override
    public List<Shop> getFood() {
        List<Shop> shops = this.baseMapper.selectFood();
        return shops;
    }

    @Override
    public List<Shop> getHappy() {
        List<Shop> happys = this.baseMapper.selectHappy();
        return happys;
    }
}
