package com.example.ylye.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.ylye.entity.Orders;
import com.example.ylye.entity.Product;
import com.example.ylye.entity.User;
import com.example.ylye.mapper.OrderMapper;
import com.example.ylye.pojo.UserOrder;
import com.example.ylye.service.OrderService;
import com.example.ylye.service.ProductService;
import com.example.ylye.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Slf4j
@Service
@RequiredArgsConstructor
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Orders> implements OrderService {


    private final ProductService productService;

    private final UserService userService;
    @Override
    public String createOrderByUid(Integer uid,Integer pid) {
        //创建订单
        Orders orders = new Orders();

        orders.setUid(uid.toString());
        orders.setCtime(DateUtil.now());
        orders.setState("未支付");
        //通过pid去查询商品信息
        Product pro = productService.getById(pid);
        orders.setOid(IdUtil.getSnowflake(1, 20).nextIdStr());
        orders.setPname(pro.getPname());
        orders.setPrice(pro.getPrice());
        save(orders);
        return orders.getOid();
    }

    @Override
    public List<Orders> findOrderByUid(Integer uid) {
        List<Orders> list = this.baseMapper.findOrderByUid(uid);
        return list;
    }

    @Override
    public List<UserOrder> getAll() {
        //
        List<UserOrder> orderList = new ArrayList<>();
        List<Orders> list = this.list();
//        System.out.println(list.size());

        for(Orders i : list){
            UserOrder userOrder = new UserOrder();
            BeanUtil.copyProperties(i,userOrder);
//            System.out.println(userOrder);
            orderList.add(userOrder);

//            System.out.println("iii"+i);
//            System.out.println("1111");
        }
//        System.out.println(orderList.size());
//        System.out.println("ss"+orderList);
        User u ;
        //通过uid来查询用户名
        for (UserOrder item : orderList){
            System.out.println("2222");
            System.out.println(item);
             u = userService.getById(item.getUid());
//             System.out.println(u);
             item.setUsername(u.getUsername());
             System.out.println(item);
        }
//        System.out.println(orderList);
//        System.out.println(orderList);
        return orderList;
    }


}
