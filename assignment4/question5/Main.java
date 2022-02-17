package question5;

public class Main {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        int length = 0;
        ListNode node = head;
        while(node != null){
            node = node.next;
            length++;
        }
        ListNode dummy = new ListNode(0, head);
        for(int subLength = 1; subLength < length; subLength <<= 1){
            ListNode pre = dummy, cur = dummy.next;
            while(cur != null){
                ListNode head1 = cur;
                for(int i = 1; i < subLength && cur.next != null; i++){
                    cur = cur.next;
                }
                ListNode head2 = cur.next;
                cur.next = null;
                cur = head2;
                for(int i = 1; i< subLength && cur != null && cur.next != null; i++){
                    cur = cur.next;
                }
                ListNode next = null;
                if(cur != null){
                    next = cur.next;
                    cur.next = null;
                }
                ListNode merged = merge(head1, head2);
                pre.next = merged;
                while(pre.next != null){
                    pre = pre.next;
                }
                cur = next;
            }
        }
        return dummy.next;
    }

    public ListNode merge(ListNode head1, ListNode head2){
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        while(head1 != null && head2 != null){
            if(head1.val <= head2.val){
                temp.next = head1;
                head1 = head1.next;
            }else{
                temp.next = head2;
                head2 = head2.next;
            }
            temp = temp.next;
        }
        if(head1 != null){
            temp.next = head1;
        }
        if(head2 != null){
            temp.next = head2;
        }
        return dummy.next;
    }
}
