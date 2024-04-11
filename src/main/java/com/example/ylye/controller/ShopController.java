package com.example.ylye.controller;

import com.example.ylye.common.Result;
import com.example.ylye.entity.Product;
import com.example.ylye.entity.Shop;
import com.example.ylye.service.ProductService;
import com.example.ylye.service.ShopService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shop")
@RequiredArgsConstructor
@Api(tags = "商店管理接口")
public class ShopController {

    private final ShopService service;

    private final ProductService productService;

    @ApiOperation("查询所有的店铺信息")
    @GetMapping()
    public Result getAll(){
        List<Shop> list = service.list();
        return Result.ok(list);
    }
    @ApiOperation("查询美食的店铺")
    @GetMapping("/food")
    public Result getFood(){
        List<Shop> list = service.getFood();
        return Result.ok(list);
    }

    @ApiOperation("查询娱乐的店铺")
    @GetMapping("/happy")
    public Result getHappy(){
        List<Shop> list = service.getHappy();
        return Result.ok(list);
    }

    @ApiOperation("查询门票信息")
    @GetMapping("/ticket")
    public Result getTicket(){
        List<Product> list = productService.list();
        return Result.ok(list);
    }

    @ApiOperation("更新店铺信息")
    @PostMapping("/save")
    public Result saveShop(@RequestBody Shop shop){
        shop.setState("营业");
        service.saveOrUpdate(shop);
        return Result.ok("更新成功");
    }
    @ApiOperation("删除店铺信息")
    @PostMapping("/del")
    public Result delShopById(@RequestParam("id")Integer sid){
        service.removeById(sid);
        return Result.ok("删除成功");
    }
}
