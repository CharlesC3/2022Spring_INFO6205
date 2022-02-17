package question7;

public class Main {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(-1, head);
        ListNode pre = dummy;
        ListNode cur = head;
        int i = 1;
        for(; i < left; i++){
            cur = cur.next;
            pre = pre.next;
        }
        ListNode node = pre;
        while(i++ <= right){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        node.next.next = cur;
        node.next = pre;
        return dummy.next;
    }
}
