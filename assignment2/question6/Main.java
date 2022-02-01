package question6;

import java.util.Arrays;

public class Main {
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int sum = 0;
        int dif = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++){
            int fixed = nums[i];
            int left = i + 1;
            int right = nums.length - 1;
            while(left < right){
                int tempSum = nums[left] + nums[right] + fixed;
                int tempDif = Math.abs(target - tempSum);
                if(tempDif < dif){
                    dif = tempDif;
                    sum = tempSum;
                }
                if(target > tempSum){
                    left++;
                }else if(target < tempSum){
                    right--;
                }else{
                    return tempSum;
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = {0, 2, 1, -3};
        System.out.println(threeSumClosest(nums, 1));
    }
}
