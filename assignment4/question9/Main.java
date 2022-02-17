package question9;

public class Main {
    public int numComponents(ListNode head, int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }

        ListNode cur = head;
        int count = 0;
        while(cur != null){
            if(set.contains(cur.val) && (cur.next == null || !set.contains(cur.next.val))){
                count++;
            }
            cur = cur.next;
        }
        return count;
    }
}
