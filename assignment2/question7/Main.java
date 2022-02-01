package question7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        int m = intervals.length;
        for(int i = 0; i < m; i++){
            int[] cur = intervals[i];
            if(cur[0] > newInterval[1]){
                res.add(cur);
            }else if(cur[1] < newInterval[0]){
                res.add(cur);
            }else{
                if(cur[1] >= newInterval[1]){
                    newInterval[1] = cur[1];
                }
                if(cur[0] <= newInterval[0]){
                    newInterval[0] = cur[0];
                }
            }
        }
        res.add(newInterval);
        res.sort((o1, o2) -> {
            return o1[0] - o2[0];
        });
        return res.toArray(new int[0][0]);
    }
}
