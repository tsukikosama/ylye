package com.example.ylye.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "商品实体")
public class Product {
    @TableId(value = "pid",type = IdType.AUTO)
    private Integer pid;
    private String pname;
    private Double price;
    private String content;
}
