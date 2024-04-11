package com.example.ylye.service;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.ylye.entity.Project;
import com.example.ylye.entity.User;
import com.example.ylye.pojo.regUser;

public interface UserService extends IService<User> {
    User login(User user);
    String reg(regUser user);

    Page<User> findByPage(Integer curr);
}
