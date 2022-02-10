package question4;


public class Main {
    public void reorderList(ListNode head) {
        if(head == null){
            return;
        }
        ListNode mid = middleNode(head);
        ListNode list1 = head;
        ListNode list2 = mid.next;
        mid.next = null;
        list2 = reverseList(list2);
        mergeList(list1, list2);
    }

    public ListNode middleNode(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public ListNode reverseList(ListNode head){
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

    public void mergeList(ListNode list1, ListNode list2){
        ListNode l1_temp;
        ListNode l2_temp;
        while(list1 != null && list2 != null){
            l1_temp = list1.next;
            l2_temp = list2.next;

            list1.next = list2;
            list1 = l1_temp;

            list2.next = list1;
            list2 = l2_temp;
        }
    }
}
