package org.unlogged.demo.models;

import java.util.Collections;
import java.util.List;

public class PerfData {

    private long mean;
    private long median;
    private List<Long> timeList;

    public PerfData(long mean, long median, List<Long> timeList) {
        this.mean = mean;
        this.median = median;
        this.timeList = timeList;
    }

    public PerfData(List<Long> timeList) {

        int n = timeList.size();
        // calculate mean
        long mean = 0;
        for (int i = 0; i <= n - 1; i++) {
            mean += timeList.get(i);
        }
        mean /= n;

        // calculate median
        long median = 0;
        Collections.sort(timeList);
        if (n % 2 != 0) {
            median = timeList.get(n/2);
        }
        else {
            median = (timeList.get((n - 1) / 2) + timeList.get(n / 2));
            median /= 2;
        }

        this.timeList = timeList;
        this.mean = mean;
        this.median = median;
    }

    public long getMean() {
        return this.mean;
    }

    public void setMean(long mean) {
        this.mean = mean;
    }

    public long getMedian() {
        return this.median;
    }

    public void setMedian(long median) {
        this.median = median;
    }

    public List<Long> getTimeList() {
        return this.timeList;
    }

    public void setTimeList(List<Long> timeList) {
        this.timeList = timeList;
    }
}
