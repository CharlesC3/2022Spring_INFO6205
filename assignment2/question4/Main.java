package question4;

import java.util.Arrays;

public class Main {
    public int minMeetingRooms(int[][] intervals) {
        int m = intervals.length;
        int[] start = new int[m];
        int[] end = new int[m];
        for(int i = 0; i < m; i++){
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int count = 0;
        int res = 0, i = 0, j = 0;
        while(i < m && j < m){
            if(start[i] < end[j]){
                count++;
                i++;
            }else{
                count--;
                j++;
            }
            res = Math.max(res, count);
        }
        return res;
    }
}
