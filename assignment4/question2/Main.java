package question2;

public class Main {
    public ListNode partition(ListNode head, int x) {
        if(head == null){
            return head;
        }
        ListNode dummyMax = new ListNode(-1);
        ListNode tempMax = dummyMax;
        ListNode dymmyMin = new ListNode(-1);
        ListNode tempMin = dymmyMin;
        ListNode cur = head;
        while(cur != null){
            if(cur.val >= x){
                tempMax.next = cur;
                tempMax = tempMax.next;
            }else{
                tempMin.next = cur;
                tempMin = tempMin.next;
            }
            cur = cur.next;
        }
        tempMax.next = null;
        tempMin.next = dummyMax.next;
        return dymmyMin.next;
    }
}
