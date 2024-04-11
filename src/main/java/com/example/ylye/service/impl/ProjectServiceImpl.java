package com.example.ylye.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.ylye.entity.Project;
import com.example.ylye.mapper.ProjectMapper;
import com.example.ylye.service.ProductService;
import com.example.ylye.service.ProjectService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProjectServiceImpl extends ServiceImpl<ProjectMapper, Project> implements ProjectService {
    @Override
    public Page<Project> getProjectByPage(Integer current) {
        Page<Project> page = new Page<>(current,10);
        //查询当前页面的数据
        List<Project> list = this.baseMapper.getProjectByPage(current);
        //封装page对象
        //设置总数
        page.setTotal(list().size());
        //设置页面数据
        page.setRecords(list);

        return page;
    }

    @Override
    public void updateOnline(String fix,Integer xid) {

        LambdaQueryWrapper<Project> wrapper = new LambdaQueryWrapper<>();

        wrapper.eq(Project::getXid,xid);

        Project project = new Project();
        project.setOnline(fix);
        this.update(project,wrapper);

    }

    @Override
    public List<Project> getProject() {
        LambdaQueryWrapper<Project> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Project::getOnline,"运行");

        return this.list(wrapper);
    }
}
