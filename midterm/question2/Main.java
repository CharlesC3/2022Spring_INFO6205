package question2;

public class Main {
    public static void main(String[] args) {

    }

    public ListNode addTwoNumber(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        int carry = 0;
        while(l1 != null || l2 != null || carry != 0){
            int sum = 0;
            if(l1 == null && l2 == null){
                sum = carry;
            }else if(l1 == null){
                sum = l2.val + carry;
                l2 = l2.next;
            }else if(l2 == null){
                sum = l1.val + carry;
                l1 = l1.next;
            }else{
                sum = l1.val + l2.val + carry;
                l1 = l1.next;
                l2 = l2.next;
            }
            sum = sum % 10;
            carry = sum / 10;
            ListNode node = new ListNode(sum);
            p.next = node;
            p = p.next;
        }
        return dummy.next;
    }
}
