package com.example.ylye.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.ylye.entity.Project;
import com.example.ylye.entity.User;
import com.example.ylye.mapper.UserMapper;
import com.example.ylye.pojo.regUser;
import com.example.ylye.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.ylye.utils.Common.REDIS_REG;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {



    private final StringRedisTemplate stringTemplate;
    /**
     * 登录功能
     * @param user
     * @return
     */
    @Override
    public User login(User user) {
        User u = baseMapper.login(user.getUsername(), user.getPassword());

        return u;
    }


    /**
     * 注册功能
     * @param user
     * @return
     */
    @Override
    public String reg(regUser user) {

        //1.验证验证码是否正确
        //1.1从redis中验证


        //2.验证密码是否一致正确
        //2.1密码一直通过
        if (!user.getPassword().equals(user.getCheckPass())){
            return "两次输入的密码不一致";
        }
        //3.保存密码
        //3.1保存密码
        User newuser = BeanUtil.copyProperties(user, User.class);
        //设置默认昵称
        newuser.setNickname(user.getUsername());
        //把用户存入数据库
        this.save(newuser);
        //清除redis中的验证码

        return "注册成功";
    }

    @Override
    public Page<User> findByPage(Integer curr) {
        Page<User> page = new Page<>(curr,10);
        //查询当前页面的数据
        List<User> list = this.baseMapper.getUserByPage(curr);
        //封装page对象
        //设置总数
        page.setTotal(list().size());
        //设置页面数据
        page.setRecords(list);
        return page;
    }


}
