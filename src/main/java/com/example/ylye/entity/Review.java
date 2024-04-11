package com.example.ylye.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "评论实体")
public class Review {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private String content;
    private Integer reply;
    private String ctime;
    private String username;
    @TableField(exist = false)
    private List<Review> replays;
    private Integer rid;
    private Integer xid;
}
