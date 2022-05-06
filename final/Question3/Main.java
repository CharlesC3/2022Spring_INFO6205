package Question3;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String[] str1 = {"eat","tea","tan","ate","nat","bat"};
        String[] str2 = {""};
        String[] str3 = {"a"};
        System.out.println(groupAnagrams(str1));
        System.out.println(groupAnagrams(str2));
        System.out.println(groupAnagrams(str3));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> codeToGroup = new HashMap<>();
        for(String str : strs){
            String code = encode(str);
            codeToGroup.putIfAbsent(code, new LinkedList<>());
            codeToGroup.get(code).add(str);
        }
        List<List<String>> res = new LinkedList<>();
        for(List<String> group : codeToGroup.values()){
            res.add(group);
        }
        return res;
    }

    public static String encode(String s){
        char[] code = new char[26];
        for(char c : s.toCharArray()){
            int delta = c - 'a';
            code[delta]++;
        }
        return new String(code);
    }
}
