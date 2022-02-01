package question10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return nSumTarget(nums, 4, 0, target);
    }

    public static List<List<Integer>> nSumTarget(int[] nums, int n, int start, int target){
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if(n < 2 || len < n){
            return res;
        }
        if(n == 2){
            int lo = start;
            int hi = len - 1;
            while(lo < hi) {
                int left = nums[lo];
                int right = nums[hi];
                int sum = left + right;
                if (sum < target) {
                    while (lo < hi && nums[lo] == left) {
                        lo++;
                    }
                } else if (sum > target) {
                    while (lo < hi && nums[hi] == right) {
                        hi--;
                    }
                } else {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(left);
                    temp.add(right);
                    res.add(temp);
                    while (lo < hi && nums[lo] == left) {
                        lo++;
                    }
                    while (lo < hi && nums[hi] == right) {
                        hi--;
                    }
                }
            }
        }else{
            for(int i = start; i < len; i++){
                List<List<Integer>> sub = nSumTarget(nums, n - 1, i + 1, target - nums[i]);
                for(List arr : sub){
                    arr.add(nums[i]);
                    res.add(arr);
                }
                while(i < len - 1 && nums[i] == nums[i + 1]){
                    i++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1,0,-1,0,-2,2};
        System.out.println(fourSum(arr, 0));
    }
}
