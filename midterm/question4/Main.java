package question4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

    }

    public static int[][] mergeInterval(int[][] intervals){
        if(intervals == null || intervals.length == 0){
            return intervals;
        }
        Arrays.sort(intervals, (a, b) ->{
            return a[0] - b[0];
        });
        List<int[]> res = new ArrayList<>();
        res.add(intervals[0]);
        for(int[] interval : intervals){
            int end = res.get(res.size() - 1)[1];
            if(interval[0] <= end){
                res.get(res.size() - 1)[1] = Math.max(interval[1], end);
            }else{
                res.add(interval);
            }
        }
        return res.toArray(new int[0][0]);
    }
}
