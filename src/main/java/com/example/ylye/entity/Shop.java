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
@ApiModel(description = "商店实体")
public class Shop {
    @TableId(value = "sid",type = IdType.AUTO)
    private Integer sid;
    private String sname;
    private String sdesc;
    private String img;
    private String state;
    private String stype;
}
