package question8;

import java.util.ArrayList;
import java.util.List;

public class Main {
    List<Integer> res = new ArrayList<>();
    public List<Integer> pancakeSort(int[] arr) {
        sort(arr, arr.length);
        return res;
    }

    public void sort(int[] arr, int n){
        if(n == 1){
            return;
        }
        int maxPancake = 0;
        int maxPancakeIndex = 0;
        for(int i = 0; i < n; i++){
            if(arr[i] > maxPancake){
                maxPancakeIndex = i;
                maxPancake = arr[i];
            }
        }

        reverse(arr, 0, maxPancakeIndex);
        res.add(maxPancakeIndex + 1);
        reverse(arr, 0, n - 1);
        res.add(n);
        sort(arr, n - 1);

    }

    public void reverse(int[] arr, int i, int j){
        while(i < j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
}
