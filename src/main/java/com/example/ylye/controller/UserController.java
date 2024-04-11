package com.example.ylye.controller;

import com.example.ylye.common.Result;
import com.example.ylye.entity.User;
import com.example.ylye.pojo.regUser;
import com.example.ylye.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@Api(tags = "用户管理接口")
@RestController
@RequestMapping("/user")
//给需要初始化的常数添加构造函数
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    @ApiOperation("登录接口")
    @PostMapping("/login")
    public Result login(@RequestBody User user){

        User u = userService.login(user);
        if(u == null){
            return Result.fail("登录失败");
        }
        return Result.ok(u);
    }

    /**
     * 注册功能
     * 注册功能
     * @param user
     * @return
     */
    @ApiOperation("注册接口")
    @PostMapping("/reg")
    private Result reg(@RequestBody regUser user){

        String msg = userService.reg(user);
        return Result.ok(msg);
    }


    @ApiOperation("查询全部用户接口")
    @GetMapping("/list")
    public Result list(){
        return Result.ok(userService.list());
    }

    @ApiOperation("修改用户接口")
    @PostMapping("/update")
    public Result update(@RequestBody User user){
        return Result.ok(userService.saveOrUpdate(user));
    }

    @ApiOperation("删除id")
    @PostMapping("/delete/{id}")
    public Result delete(@PathVariable("id")Integer id){
        userService.removeById(id);
        return Result.ok("删除成功");
    }
    @ApiOperation("通过id查询用户")
    @GetMapping("/find/{id}")
    public Result findById(@PathVariable("id")Integer id){
        return Result.ok(userService.getById(id));
    }

    @ApiOperation("分页查询用户")
    @GetMapping("/{curr}")
    public Result findByPage(@PathVariable("curr")Integer curr){
        return Result.ok(userService.findByPage(curr));
    }
}
