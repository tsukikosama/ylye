package com.example.ylye.controller;

import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.ylye.common.Result;
import com.example.ylye.entity.News;
import com.example.ylye.service.NewsService;
import com.example.ylye.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "新闻管理接口")
@RestController
@RequestMapping("/news")
//给需要初始化的常数添加构造函数
@RequiredArgsConstructor
public class NewsController {


    private final NewsService newsService;

    /**
     * 查询全部新闻
     * @return
     */
    @ApiOperation("查询全部新闻接口")
    @GetMapping("/all")
    public Result getAllNews(){
        List<News> list = newsService.list();
        return Result.ok(list);
    }

    @ApiOperation("分页查询新闻")
    @GetMapping("/{page}")
    public Result getNewsByPage(@PathVariable(value = "page",required = false) Integer page){
       Page<News> pages = newsService.findNewsByPage(page);
       return Result.ok(pages);
    }

    @ApiOperation("查询最新发布的新闻")
    @GetMapping("/new")
    public Result getHotNew(){
        List<News> list = newsService.getNew();
        return Result.ok(list);
    }

    @ApiOperation("查询新闻类型")
    @GetMapping("/hot")
    public Result getHotNews(){
        List<News> list = newsService.getHot();
        return Result.ok(list);
    }

    @ApiOperation("查询娱乐新闻")
    @GetMapping("/yl")
    public Result getYl(){
        List<News> list = newsService.getYl();
        return Result.ok(list);
    }

    @ApiOperation("按页数和分类查询查询新闻")
    @GetMapping("/new/{page}")
    public Result getNewsByPage(@PathVariable("page")Integer page, @RequestParam("type")Integer type){
        Page<News> list = newsService.getNewsByPage(page,type);
        return Result.ok(list);
    }
    @ApiOperation("添加新闻")
    @PostMapping("/add")
    public Result addNews(@RequestBody News news){
        news.setCtime(DateUtil.now());
        newsService.saveOrUpdate(news);
        return Result.ok("添加成功");
    }

    @ApiOperation("删除页面")
    @PostMapping("/del")
    public Result delNews(@RequestParam("nid")Integer nid){
        newsService.delByNid(nid);
        return Result.ok("删除成功");
    }

    @ApiOperation("通过nid查询新闻")
    @GetMapping("/more/{id}")
    public Result newsById(@PathVariable("id")Integer id){
        News byId = newsService.getById(id);
        return Result.ok(byId);
    }
}
