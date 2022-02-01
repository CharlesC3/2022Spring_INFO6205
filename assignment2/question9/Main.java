package question9;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> res = new ArrayList<>();
        int i = 0;
        int j = 0;
        while(i < firstList.length && j < secondList.length){
            int a1 = firstList[i][0];
            int a2 = firstList[i][1];
            int b1 = secondList[j][0];
            int b2 = secondList[j][1];
            if(a2 >= b1 && b2 >= a1){
                res.add(new int[]{Math.max(a1, b1), Math.min(a2, b2)});
            }
            if(b2 > a2){
                i++;
            }else{
                j++;
            }
        }
        return res.toArray(new int[0][0]);
    }
}
