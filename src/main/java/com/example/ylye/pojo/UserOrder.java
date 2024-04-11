package com.example.ylye.pojo;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "支付管理实体")
public class UserOrder {
    private String oid;
    private String uid;
    //    @TableField(fill= FieldFill.INSERT)
    private String ctime;
    private String state;
    private String pname;
    private String ptime;
    private String zfbid;
    private String username;
}
