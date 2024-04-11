package com.example.ylye.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.ylye.entity.Orders;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface OrderMapper extends BaseMapper<Orders> {
    Orders selectByOid(String oid);

    void updateState(String tradeNo, String state, String gmtPayment, String alipayTradeNo);

    List<Orders> findOrderByUid(Integer uid);
}
