package question6;

public class Main {
    public static String reorganizeString(String s) {
        char[] arr = s.toCharArray();
        int[] alphabetCount = new int[26];
        int len = s.length();
        for(int i = 0; i < len; i++){
            alphabetCount[arr[i] - 'a']++;
        }
        int max = 0;
        int maxAlphabet = 0;
        int threshold = (arr.length + 1) / 2;
        for(int i = 0; i < 26; i++){
            if(alphabetCount[i] > max){
                max = alphabetCount[i];
                maxAlphabet = i;
                if(max > threshold){
                    return "";
                }
            }
        }
        char[] res = new char[len];
        int index = 0;
        while(alphabetCount[maxAlphabet]-- > 0){
            res[index] = (char)(maxAlphabet + 'a');
            index += 2;
        }
        for(int i = 0; i < 26; i++){
            while(alphabetCount[i]-- > 0){
                if(index >= len){
                    index = 1;
                }
                res[index] = (char)(i + 'a');
                index += 2;
            }
        }
        return new String(res);
    }

    public static void main(String[] args) {
        String s = "aab";
        System.out.println(reorganizeString(s));
    }
}
