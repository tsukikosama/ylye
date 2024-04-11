package com.example.ylye.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.ylye.entity.Project;

import java.util.List;

public interface ProjectService extends IService<Project> {
    Page<Project> getProjectByPage(Integer current);

    void updateOnline(String fix,Integer xid);

    List<Project> getProject();
}
