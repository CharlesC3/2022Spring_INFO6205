package question8;

public class Main {
    public Node insert(Node head, int insertVal) {
        if(head == null){
            Node node = new Node(insertVal);
            node.next = node;
            return node;
        }

        Node pre = head;
        Node cur = head.next;
        boolean toInsert = false;
        do{
            if(pre.val <= insertVal && cur.val >= insertVal){
                toInsert = true;
            }else if(pre.val > cur.val){
                if(pre.val < insertVal || cur.val > insertVal){
                    toInsert = true;
                }
            }
            if(toInsert){
                Node node = new Node(insertVal, cur);
                pre.next = node;
                return head;
            }
            pre = cur;
            cur = cur.next;
        }while(pre != head);

        Node node = new Node(insertVal, cur);
        pre.next = node;
        return head;
    }
}
