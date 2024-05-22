package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.Sleep_quality_reminders;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/*
 * 1.使用@Mapper注解 ，代表这个接口被mybatis接管
 * 2.继承BaseMapper<属性类名>
 * */
@Mapper
public interface SleepqualityMapper extends BaseMapper<Sleep_quality_reminders> {

    @Select("SELECT AVG(sleep_duration) FROM sleep_quality WHERE user_id = #{userId}")
    Double selectAvgSleepDurationByUserId(Integer userId);

    @Select("SELECT AVG(deep_sleep_time / sleep_duration) FROM sleep_quality WHERE user_id = #{userId}")
    Double selectAvgDeepSleepRatioByUserId(Integer userId);


}

