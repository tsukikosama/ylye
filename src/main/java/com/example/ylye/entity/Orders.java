package com.example.ylye.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "用户表单实体")
public class Orders {
    @TableId(value = "oid")
    private String oid;
    private String uid;
//    @TableField(fill= FieldFill.INSERT)
    private String ctime;
    private String state;
    private String pname;
    private String ptime;
    private Double price;
    private String zfbid;
}
