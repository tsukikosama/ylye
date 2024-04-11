package com.example.ylye.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.ylye.entity.Project;
import org.apache.ibatis.annotations.Mapper;

import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ProjectMapper extends BaseMapper<Project> {

    List<Project> getProjectByPage(Integer current);
}
