package com.example.ylye.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EditImg {
//     "url": "xxx", // 图片 src ，必须
//             "alt": "yyy", // 图片描述文字，非必须
//             "href": "zzz" // 图片的链接，非必须
    private String url;
    private String alt;
    private String href;
}
