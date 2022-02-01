package question3;

public class Main {
    public static int findMin(int[] nums) {
        if(nums.length == 1 || nums[0] < nums[nums.length - 1]){
            return nums[0];
        }
        int left = 0;
        int right = nums.length - 1;
        while(left < right){
            int mid = left + (right - left) / 2;
            if(nums[mid] >= nums[0]){
                left = mid + 1;
            }else if(nums[mid] < nums[0]){
                right = mid;
            }
        }
        return nums[left];
    }

    public static void main(String[] args) {
        int[] nums = {3,4,5,1,2};
        System.out.println(findMin(nums));
    }
}
