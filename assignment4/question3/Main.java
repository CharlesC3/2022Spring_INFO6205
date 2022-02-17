package question3;

public class Main {
    public ListNode reverseEvenLengthGroups(ListNode head) {
        int len = 0;
        for(ListNode node = head; node != null; node = node.next, len++);
        ListNode[] list = new ListNode[len];
        for(int i = 0; i < len; i++, head = head.next){
            list[i] = head;
        }
        for(int i = 0, k = 1; i < len; k++){
            int j = Math.min(len - 1, i + k - 1);
            if((j - i + 1) % 2 == 0){
                reverse(list, i, j);
            }
            i = j + 1;
        }
        for(int i = 0; i < len - 1; i++){
            list[i].next = list[i + 1];
        }
        list[len - 1].next = null;
        return list[0];
    }

    public void reverse(ListNode[] list, int i, int j){
        while(i < j){
            ListNode temp = list[i];
            list[i++] = list[j];
            list[j--] = temp;
        }
    }
}
