package question5;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        int l = 0, r = arr.length - k;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (x - arr[mid] > arr[mid + k] - x) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            res.add(arr[i + l]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {-2,-1,1,2,3,4,5};
        System.out.println(findClosestElements(arr, 7, 2).toString());
    }
}
