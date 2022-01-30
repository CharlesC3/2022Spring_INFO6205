package question1;

import java.util.Arrays;

public class Main {
    public static void sortColors(int[] nums){
        if(nums == null || nums.length == 0){
            return;
        }
        int low = 0;
        int high = nums.length - 1;
        int i = 0;
        while(i <= high){
            if(nums[i] > 1){
                swap(nums, i, high);
                high--;
            }else if(nums[i] < 1){
                swap(nums, i, low);
                i++;
                low++;
            }else{
                i++;
            }
        }
    }

    public static void swap(int[] nums, int i, int j){
        if(nums == null || i < 0 || j < 0 || i >= nums.length || j > nums.length || i == j){
            return;
        }
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 2, 1, 0, 2, 1, 1, 0};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}
