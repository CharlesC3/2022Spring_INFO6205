package question8;

public class Main {
    public ListNode[] splitListToParts(ListNode head, int k) {
        int length = 0;
        ListNode node = head;
        while(node != null){
            node = node.next;
            length++;
        }
        int quotient = length / k;
        int remainder = length % k;
        ListNode[] parts = new ListNode[k];
        ListNode cur = head;
        for(int i = 0; i < k && cur != null; i++){
            parts[i] = cur;
            int partSize = quotient +(i < remainder ? 1 : 0);
            for(int j = 1; j < partSize; j++){
                cur = cur.next;
            }
            ListNode next = cur.next;
            cur.next = null;
            cur = next;
        }
        return parts;
    }
}
