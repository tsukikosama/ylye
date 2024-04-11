package com.example.ylye.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "用户表单实体")
public class User {
    @TableId(value = "uid",type = IdType.AUTO)
    @ApiModelProperty("id")
    private Integer uid;
    private String username;
    private String password;
    private String nickname;
    private String email;
    private String icon;
    private Integer type;
}
