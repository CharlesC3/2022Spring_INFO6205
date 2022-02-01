package question8;

import java.util.Arrays;

public class Main {
    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals == null || intervals.length == 0){
            return 0;
        }
        Arrays.sort(intervals, (o1, o2) ->{
            return o1[1] - o2[1];
        });

        int count = 1;
        int x = intervals[0][1];
        for(int[] interval : intervals){
            int start = interval[0];
            if(start >= x){
                count++;
                x = interval[1];
            }
        }
        return intervals.length - count;
    }
}
