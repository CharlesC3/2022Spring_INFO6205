package question3;

public class Main {
    public static int hIndex(int[] citations) {
        int len = citations.length;
        int[] counter = new int[len + 1];
        for(int i = 0; i < len; i++){
            if(citations[i] >= len){
                counter[len]++;
            }else{
                counter[citations[i]]++;
            }
        }

        int tot = 0;
        for(int i = len; i >= 0; i--){
            tot += counter[i];
            if(tot >= i){
                return i;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] citations = {3,0,6,1,5};
        System.out.println(hIndex(citations));
    }
}
