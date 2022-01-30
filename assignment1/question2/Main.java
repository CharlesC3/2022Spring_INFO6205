package question2;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static List<Integer> majorityElement(int[] nums) {
        int element1 = 0;
        int element2 = 0;
        int vote1 = 0;
        int vote2 = 0;

        for(int num : nums){
            if(vote1 > 0 && element1 == num){
                vote1++;
            }else if(vote2 > 0 && element2 == num){
                vote2++;
            }else if(vote1 == 0){
                element1 = num;
                vote1++;
            }else if(vote2 == 0){
                element2 = num;
                vote2++;
            }else{
                vote1--;
                vote2--;
            }
        }

        int count1 = 0;
        int count2 = 0;
        for(int num : nums){
            if(vote1 > 0 && element1 == num){
                count1++;
            }
            if(vote2 > 0 && element2 == num){
                count2++;
            }
        }
        List<Integer> list = new ArrayList<>();
        if(vote1 > 0 && count1 > nums.length / 3){
            list.add(element1);
        }
        if(vote2 > 0 && count2 > nums.length / 3){
            list.add(element2);
        }
        return list;
    }

    public static void main(String[] args) {
        int[] arr = {2,1,1,3,1,4,5,6};
        System.out.println(majorityElement(arr));
    }
}
