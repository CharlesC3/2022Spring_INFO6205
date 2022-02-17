package question6;

public class Main {
    List<Integer> list;
    Random random;

    public Solution(ListNode head) {
        list = new ArrayList<>();
        while(head != null){
            list.add(head.val);
            head = head.next;
        }
        random = new Random();
    }

    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }
}
