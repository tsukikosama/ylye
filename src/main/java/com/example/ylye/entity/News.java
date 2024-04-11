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
@ApiModel(value = "新闻实体")
public class News {
    @TableId(value = "nid", type = IdType.AUTO)
    private Integer nid;
    private String title;
    private String content;
    private String ctime;
    private Integer ntype;
}
