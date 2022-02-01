package question5;

import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Main {
    public static int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) ->{
            return map.get(o1) - map.get(o2);
        });

        for(int key : map.keySet()){
            if(queue.size() < k){
                queue.add(key);
            }else if(map.get(key) > map.get(queue.peek())){
                queue.remove();
                queue.add(key);
            }
        }
        int[] res = new int[k];
        for(int i = 0; i < k; i++){
            res[i] = queue.remove();
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1,1,1,2,2,3};
        System.out.println(Arrays.toString(topKFrequent(arr, 2)));
    }
}
