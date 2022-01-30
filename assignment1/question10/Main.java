package question10;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap<>();
        for(String word : words){
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        List<String> list = new ArrayList<>(map.keySet());
        list.sort(
                (o1, o2) ->{
                    if(map.get(o1) == map.get(o2)){
                        return o1.compareTo(o2);
                    }
                    return map.get(o2) - map.get(o1);
                }
        );
        return list.subList(0, k);
    }

    public static void main(String[] args) {
        String[] words = {"i", "love", "leetcode", "i", "love", "coding"};
        int k = 2;
        List<String> list = topKFrequent(words, k);
        for(int i = 0; i < list.size(); i++){
            System.out.println(list.get(i));
        }
    }
}
