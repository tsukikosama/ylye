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
@ApiModel(description = "游乐项目实体")
public class Project {
    @TableId(value = "xid",type = IdType.AUTO)
    private Integer xid;
    private String xname;
    private String descript;
    private String url;
    private Double score1;
    private Double score2;
    //1 不在线  1 在线
    private String online;
}
