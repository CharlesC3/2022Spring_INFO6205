package question4;

public class Main {
    int minDist = -1, maxDist = -1;
    int first = -1, last = -1, pos = 0;
    ListNode cur = head;
        while(cur.next.next != null){
        int x = cur.val;
        int y = cur.next.val;
        int z = cur.next.next.val;
        if(y > Math.max(x, z) || y < Math.min(x, z)){
            if(last != -1){
                if(minDist == -1){
                    minDist = pos - last;
                }else{
                    minDist = Math.min(minDist, pos - last);
                }
                maxDist = Math.max(maxDist, pos - first);
            }
            if(first == -1){
                first = pos;
            }
            last = pos;
        }
        cur = cur.next;
        pos += 1;
    }
        return new int[]{minDist, maxDist};
}
