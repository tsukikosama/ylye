package com.example.ylye.service.impl;



import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.ylye.entity.Product;
import com.example.ylye.mapper.ProductMapper;
import com.example.ylye.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {
}
