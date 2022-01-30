package question9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static int[] frequencySort(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Integer> list = new ArrayList<>(map.keySet());
        list.sort(
                (o1, o2) ->{
                    if(map.get(o1) == map.get(o2)){
                        return o2 - o1;
                    }
                    return map.get(o1) - map.get(o2);
                }
        );
        int[] res = new int[nums.length];
        int i = 0, j = 0;
        while(j < list.size()){
            for(int val = 0; val < map.get(list.get(j)); val++){
                res[i++] = list.get(j);
            }
            j++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,2,2,2,3};
        System.out.println(Arrays.toString(frequencySort(nums)));
    }
}
