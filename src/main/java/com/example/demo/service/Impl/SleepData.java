package com.example.demo.service.Impl;

public class SleepData {
    private Float sleepDuration;
    private double deepSleepRatio;

    public SleepData(Float sleepDuration, double deepSleepRatio) {
        this.sleepDuration = sleepDuration;
        this.deepSleepRatio = deepSleepRatio;
    }

    public Float getSleepDuration() {
        return sleepDuration;
    }

    public void setSleepDuration(Float sleepDuration) {
        this.sleepDuration = sleepDuration;
    }

    public double getDeepSleepRatio() {
        return deepSleepRatio;
    }

    public void setDeepSleepRatio(double deepSleepRatio) {
        this.deepSleepRatio = deepSleepRatio;
    }
}

