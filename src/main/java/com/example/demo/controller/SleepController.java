package com.example.demo.controller;

import com.example.demo.entity.Sleep_quality_reminders;
import com.example.demo.service.ISleepqualityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/sleepquality")
public class SleepController {

    @Autowired
    private ISleepqualityService iSleepqualityService;

    @GetMapping("/average/{userId}")
    public ResponseEntity<Map<String, Double>> getAverageSleepData(@PathVariable Integer userId) {
        Map<String, Double> averages = iSleepqualityService.getAverageSleepDataByUserId(userId);
        return ResponseEntity.ok(averages);
    }

    @GetMapping("/lastSevenDaysScores")
    public List<Sleep_quality_reminders> getLastSevenDaysScores(@RequestParam int userId) {
        return iSleepqualityService.getLastSevenDaysScores(userId);
    }

    // 获取用户平均质量得分
    @GetMapping("/sleepquality/averageScores")
    public List<Map<String, Object>> getAverageQualityScores() {
        return iSleepqualityService.getAverageQualityScores();
    }

    // 进行排名
    @GetMapping("/sleepquality/userRank")
    public Map<String, Object> getUserRank(@RequestParam Integer userId) {
        List<Map<String, Object>> averageScores = iSleepqualityService.getAverageQualityScores();
        int rank = 1;
        for (Map<String, Object> userScore : averageScores) {
            if (userScore.get("userId").equals(userId)) {
                break;
            }
            rank++;
        }
        Map<String, Object> result = new HashMap<>();
        result.put("userId", userId);
        result.put("rank", rank);
        return result;
    }

}




