package Question1;

public class Main {
    public static void main(String[] args) {
        String str1 = "aabcccccaaa";
        String str2 = "ab";
        System.out.println(compressString(str1));
        System.out.println(compressString(str2));
    }

    public static String compressString(String str) {
        if(str.length() == 0){
            return str;
        }
        StringBuilder sb = new StringBuilder();
        int count = 1;
        char c = str.charAt(0);
        for(int i = 1; i < str.length(); i++){
            if(c == str.charAt(i)){
                count++;
            }else{
                sb.append(c);
                sb.append(count);
                c = str.charAt(i);
                count = 1;
            }
        }
        sb.append(c);
        sb.append(count);
        return sb.length() >= str.length() ? str : sb.toString();
    }
}
