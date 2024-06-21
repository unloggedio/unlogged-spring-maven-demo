package org.unlogged.demo.service;

import org.springframework.stereotype.Service;
import org.unlogged.demo.models.PerfData;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@Service
public class PerfService {

	private int count_prime_calc(long value) {
        // This is O(n^2) implementation for calculating the prime numbers from 1 to value
        // This uses brute force to calculate it, and is CPU intensive single-threaded operation

        int count = 0;
        for (long i=2;i<=value;i++) {
            Boolean isPrime = true;
            for (long j=2;j<=i-1;j++) {
                if (i%j == 0) {
                    isPrime = false;
                }
            }

            if (isPrime) {
                count++;
            }
        }
        return count;
    }

    public List<Long> sum_natural(int count) {
        long timestamp_1 = System.currentTimeMillis();

        // write value to memory
        List<Integer> value_list = new LinkedList<>();
        for (int i=0;i<=count-1;i++) {
            value_list.add(i);
        }
        long timestamp_2 = System.currentTimeMillis();

        // read value from memory
        long sum=0;
        for (int i=0;i<value_list.size()-1;i++) {
            sum += value_list.get(i);
        }
        long timestamp_3 = System.currentTimeMillis();

        long time_write = timestamp_2 - timestamp_1;
        long time_read = timestamp_3 - timestamp_2;
        List<Long> val = Arrays.asList(time_write, time_read, sum);
        return val;
    }

    public PerfData getCpuIntensiveData(long methodCount, long value) {

        List<Long> timeList = new ArrayList<Long>();
        for (int i=0;i<=methodCount-1;i++) {
            long timeStartSingle = System.currentTimeMillis();;
            int count = this.count_prime_calc(value);
            long timeEndSingle = System.currentTimeMillis();

            timeList.add(timeEndSingle - timeStartSingle);
        }

        return new PerfData(timeList);
    }
	
}
