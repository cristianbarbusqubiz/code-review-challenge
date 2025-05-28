package com.java.challenge.statistics;

public class StatisticsCollector {

    private volatile long total = 0;
    private volatile long count = 0;

    public void record(long value) {
        total += value;
        count++;
    }

    public double average() {
        return count == 0 ? 0 : (double) total / count;
    }
}

