package question9;

public class Main {
    public int[] nextLargerNodes(ListNode head) {
        ListNode node = head;
        Stack<Integer> stack = new Stack<>();
        int len = 0;

        while(node != null){
            len++;
            node = node.next;
        }
        node = head;
        int[] nums = new int[len];
        int[] res = new int[len];
        for(int i = 0; i < len; i++){
            nums[i] = node.val;
            node = node.next;
        }
        for(int i = 0; i < len; i++){
            while(!stack.isEmpty() && nums[stack.peek()] < nums[i]){
                res[stack.peek()] = nums[i];
                stack.pop();
            }
            stack.push(i);
        }
        return res;
    }
}
