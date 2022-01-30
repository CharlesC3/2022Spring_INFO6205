package question4;

import java.util.*;

public class Main {
    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<Integer>();
        Set<Integer> set2 = new HashSet<Integer>();
        for (int num : nums1) {
            set1.add(num);
        }
        for (int num : nums2) {
            set2.add(num);
        }
        return getIntersection(set1, set2);
    }

    public static int[] getIntersection(Set<Integer> set1, Set<Integer> set2) {
        if (set1.size() > set2.size()) {
            return getIntersection(set2, set1);
        }

        List<Integer> res = new ArrayList<>();
        for (int num : set1) {
            if (set2.contains(num)) {
                res.add(num);
            }
        }
        int[] arr = new int[res.size()];
        for(int i = 0; i < arr.length; i++){
            arr[i] = res.get(i);
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 5, 6, 3};
        int[] nums2 = {1, 5, 3, 2};
        System.out.println(Arrays.toString(intersection(nums1, nums2)));
    }
}
