package question7;

import java.util.HashMap;

public class Main {
    public static String customSortString(String order, String s) {
        char[] arr = s.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        for(char ch : arr){
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        StringBuilder res = new StringBuilder();
        for(int i = 0; i < order.length(); i++){
            char cur = order.charAt(i);
            if(map.containsKey(cur)){
                while(map.get(cur) > 0){
                    res.append(cur);
                    map.put(cur, map.get(cur) - 1);
                }
            }
        }

        for(char ch : map.keySet()){
            if(map.get(ch) != 0){
                while(map.get(ch) > 0){
                    res.append(ch);
                    map.put(ch, map.get(ch) - 1);
                }
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        String s = "cba";
        String t = "abcd";
        System.out.println(customSortString(s, t));
    }
}
