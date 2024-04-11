package com.example.ylye.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.ylye.common.Result;
import com.example.ylye.entity.Project;
import com.example.ylye.service.ProjectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/project")
@Api("娱乐项目接口")
@RequiredArgsConstructor
public class ProjectController {
    private final ProjectService projectService;

    @ApiOperation("查询所有项目")
    @GetMapping("/all")
    public Result getAll(){
        List<Project> list = projectService.getProject();
        return Result.ok(list);
    }

    @ApiOperation("分页查询娱乐项目")
    @GetMapping("/{page}")
    public Result getProjectByPage(@PathVariable(value = "page",required = false)Integer current){
        Page<Project> page = projectService.getProjectByPage(current);
        return Result.ok(page);
    }
    @ApiOperation("添加项目")
    @PostMapping("/submit")
    public Result submit(@RequestBody Project project){
        System.out.println(project);
        project.setOnline("运行");
        projectService.saveOrUpdate(project);
        return Result.ok("添加成功");
    }

    @ApiOperation("更新状态")
    @PostMapping("/fix")
    public Result fixByXid(@RequestParam("online")String fix,@RequestParam("xid")Integer xid){
        projectService.updateOnline(fix,xid);
        return Result.ok();
    }

}
