package question6;

public class Main {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null){
            return null;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode left = head;
        ListNode right = head;
        ListNode pre = dummy;

        while(n > 0){
            right = right.next;
            n--;
        }

        while(right != null){
            right = right.next;
            left = left.next;
            pre = pre.next;
        }

        pre.next = left.next;
        left = left.next;
        return dummy.next;
    }
}
