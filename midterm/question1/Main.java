package question1;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int[] nums = {0,1,3,50,75};
        int lower = 0;
        int upper = 99;
        String[] strs = findmisssing(nums, lower, upper);
        for(String str : strs){
            System.out.println(str);
        }
    }

    public static String[] findmisssing(int[] nums, int lower, int upper){
        List<String> res = new ArrayList<>();
        int[] temp;
        if(nums[0] == upper && nums[nums.length - 1] == upper) {
            temp = nums;
        }else if(nums[0] == lower || nums[nums.length - 1] == upper){
            temp = new int[nums.length + 1];
            if(nums[0] == lower){
                temp[temp.length - 1] = upper;
                for(int i = 0; i < temp.length - 1; i++){
                    temp[i] = nums[i];
                }
            }else{
                temp[0] = lower;
                for(int i = 1; i < temp.length; i++){
                    temp[i] = nums[i -1];
                }
            }
        }else{
            temp = new int[nums.length + 2];
            for(int i = 1; i < temp.length - 1; i++){
                temp[i] = nums[i - 1];
            }
        }
        for(int i = 0; i < temp.length - 1; i++){
            if(temp[i] + 1 == temp[i + 1] - 1){
                res.add(Integer.toString(temp[i] + 1));
            }else if(temp[i] + 1 < temp[i + 1] - 1){
                int start = temp[i] + 1;
                if(start == lower + 1){
                    if(nums[0] != lower){
                        start = lower;
                    }
                }
                int end = temp[i + 1] - 1;
                if(end == upper - 1){
                    if(nums[nums.length - 1] != upper){
                        end = upper;
                    }
                }
                StringBuilder sb = new StringBuilder();
                sb.append(start);
                sb.append("->");
                sb.append(end);
                res.add(sb.toString());
            }
        }
        String[] res1 = new String[res.size()];
        for(int i = 0; i < res.size(); i++){
            res1[i] = res.get(i);
        }
        return res1;
    }
}
