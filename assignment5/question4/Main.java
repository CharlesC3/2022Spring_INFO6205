package question4;

public class Main {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int sz = queue.size();
            int max = Integer.MIN_VALUE;
            for(int i = 0; i < sz; i++){
                TreeNode cur = queue.poll();
                max = Math.max(max, cur.val);
                if(cur.left != null){
                    queue.offer(cur.left);
                }
                if(cur.right != null){
                    queue.offer(cur.right);
                }
            }
            res.add(max);
        }
        return res;
    }
}
