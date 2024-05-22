package com.example.demo.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.entity.Sleep_quality_reminders;
import com.example.demo.mapper.SleepqualityMapper;
import com.example.demo.service.ISleepqualityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class SleepqualityServiceImpl extends ServiceImpl<SleepqualityMapper, Sleep_quality_reminders> implements ISleepqualityService {

    @Autowired
    private SleepqualityMapper sleepqualityMapper;

    public Map<String, Double> getAverageSleepDataByUserId(Integer userId) {
        Map<String, Double> averages = new HashMap<>();
        Double avgSleepDuration = sleepqualityMapper.selectAvgSleepDurationByUserId(userId);
        Double avgDeepSleepRatio = sleepqualityMapper.selectAvgDeepSleepRatioByUserId(userId);
        averages.put("avgSleepDuration", avgSleepDuration);
        averages.put("avgDeepSleepRatio", avgDeepSleepRatio);
        return averages;
    }

    // 获取过去七天睡眠质量
    @Override
    public List<Sleep_quality_reminders> getLastSevenDaysScores(int userId) {
        QueryWrapper<Sleep_quality_reminders> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", userId).orderByDesc("date").last("limit 7");
        return sleepqualityMapper.selectList(queryWrapper);
    }


    // 获取得分排名
    @Override
    public List<Map<String, Object>> getAverageQualityScores() {
        QueryWrapper<Sleep_quality_reminders> queryWrapper = new QueryWrapper<>();
        List<Sleep_quality_reminders> allRecords = sleepqualityMapper.selectList(queryWrapper);

        // 按用户ID分组，并计算平均得分
        Map<Integer, Double> averageScores = allRecords.stream()
                .collect(Collectors.groupingBy(Sleep_quality_reminders::getUserId, Collectors.averagingDouble(Sleep_quality_reminders::getQualityScore)));

        // 将结果转换为列表并按平均得分排序
        List<Map<String, Object>> sortedAverageScores = averageScores.entrySet().stream()
                .map(entry -> {
                    Map<String, Object> result = new HashMap<>();
                    result.put("userId", entry.getKey());
                    result.put("averageScore", entry.getValue());
                    return result;
                })
                .sorted((a, b) -> Double.compare((Double) b.get("averageScore"), (Double) a.get("averageScore")))
                .collect(Collectors.toList());

        return sortedAverageScores;
    }


}

