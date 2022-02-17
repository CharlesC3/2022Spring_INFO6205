package question1;

public class Main {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode pre = list1;
        ListNode next = list1;
        for(int i = 0; i < b - a + 2; i++){
            next = next.next;
        }
        for(int i = 0; i < a - 1; i++){
            pre = pre.next;
            next = next.next;
        }
        ListNode end = list2;
        while(end.next != null){
            end = end.next;
        }
        pre.next = list2;
        end.next = next;
        return list1;
    }
}
