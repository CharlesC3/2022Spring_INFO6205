package question10;

public class Main {
    public int pairSum(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode temp = reverse(slow);
        int res = Integer.MIN_VALUE;
        while(temp != null){
            int sum = head.val + temp.val;
            res = Math.max(sum, res);
            head = head.next;
            temp = temp.next;
        }
        return res;
    }

    public ListNode reverse(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode pre = null;
        ListNode next = null;
        while(head != null){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}
