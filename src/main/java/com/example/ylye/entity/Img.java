package com.example.ylye.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Img {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String url;

    private String type;

    private String updateTime;

}
