package com.example.demo.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.entity.Sleep_quality_reminders;
import com.example.demo.mapper.SleepqualityMapper;
import com.example.demo.service.ISleepqualityService;
import org.springframework.stereotype.Service;
/*
 * 1.@Service--------使用@Service注解，让人知道这个是服务层
 * 2.extends ServiceImpl<UserMapper, User> ---继承和UserService类里面继承的方法一样，
 * 但是这里面还偷偷藏了UserService自定义的方法
 * 3.implements IUserService---实现接口
 * */

@Service
public class SleepqualityServiceImpl extends ServiceImpl<SleepqualityMapper, Sleep_quality_reminders> implements ISleepqualityService {
    //登录业务
    //登录校验业务
    //创建用户检查业务等等
}
