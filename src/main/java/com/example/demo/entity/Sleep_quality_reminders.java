package com.example.demo.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDate;

@Data  //1
@TableName(value = "sleep_quality")    //2
public class Sleep_quality_reminders {

    @ApiModelProperty("id")  //4
    @TableId(value = "id", type = IdType.AUTO) //5
    private Integer id;  //3

    @ApiModelProperty("用户id")  //4
    private Integer userId;  //3

    @ApiModelProperty("睡眠质量得分")  //4
    private Double qualityScore;   //3

    @ApiModelProperty("深度睡眠时间")  //4
    private Float  deepSleepTime;   //3

    @ApiModelProperty("睡眠比例")  //4
    private Float  sleepDuration;   //3

    @ApiModelProperty("记录日期")
    @TableField("date")  // 如果数据库列名与字段名不同，可以使用此注解指定列名
    private LocalDate date;
}
