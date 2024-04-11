package com.example.ylye.common;

import cn.hutool.core.io.file.FileNameUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.json.JSONUtil;

import com.example.ylye.entity.EditImg;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequestMapping("/upload")
@Log4j2
public class upload {

    //读取上传文件的地址
    @Value("${yly.uploadurl}")
    private String url ;
    @Value("${yly.localurl}")
    private String localurl ;
    /**
     * 这是图片上传的公共主键
     */
    @PostMapping
    public Result uploadImg(@RequestParam("file") MultipartFile file){
//        System.out.println(file);
        //获取文件上传路径
        String url = getUrl(file);
        return Result.ok(url);
    }


    /**
     * wangedit文件上传功能
     * @param file
     * @return
     */
    @PostMapping("edit/upload")
    public String uploadfile(@RequestParam("file") MultipartFile file){


        Map<String,Object> map = new LinkedHashMap<>();
        System.out.println(file);
        map.put("errno",0);

        String url = getUrl(file);

        EditImg img = new EditImg();
        img.setUrl(url);
        img.setHref(url);

        map.put("data",img);
        System.out.println(JSONUtil.toJsonStr(map));
        return JSONUtil.toJsonStr(map);
    }

    @PostMapping("/img")
    public String getFileUrl(HttpServletRequest request ,@RequestParam(value = "file")MultipartFile file){
        System.out.println(file);
        return getUrl(file);
    }

    /**
     * 传文件获取文件的服务器路径
     * @param file
     * @return
     */
    public String getUrl(MultipartFile file){
        String path = localurl;
        System.out.println("上传路径"+path);
        File f = new File(path);
        if(!f.exists()){
            System.out.println("1");
            f.mkdirs();
        }
        //获取图片名称
        String name = file.getOriginalFilename();
        //获取图片后缀
        String suffix = FileNameUtil.extName(name);
//        InputStream inputStream = file.getInputStream();
        //重命名图片
        String newFileName = IdUtil.randomUUID();
        newFileName = newFileName+"."+suffix;
        try {
            System.out.println(url);
            System.out.println(newFileName);
            //把文件写入对应的位置
            file.transferTo(new File(path+newFileName));
        }catch (IOException e){
            log.error("图片上传异常");
            throw new RuntimeException("文件上传异常");
        }
        return url+newFileName;
    }
}

