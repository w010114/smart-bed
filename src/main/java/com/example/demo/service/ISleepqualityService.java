package com.example.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.entity.Sleep_quality_reminders;
import com.example.demo.service.Impl.SleepData;

import java.util.List;
import java.util.Map;

public interface ISleepqualityService extends IService<Sleep_quality_reminders> {

     Map<String, Double> getAverageSleepDataByUserId(Integer userId);


     // 获取过去七天睡眠质量
     List<Sleep_quality_reminders> getLastSevenDaysScores(int userId);

     // 获取得分排名
     List<Map<String, Object>> getAverageQualityScores();
}
