package question3;

public class Main {
    class Pair{
        TreeNode node;
        int id;

        public Pair(TreeNode node, int id){
            this.node = node;
            this.id = id;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        if(root == null){
            return 0;
        }
        int maxWidth = 0;
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, 1));
        while(!queue.isEmpty()){
            int sz = queue.size();
            int start = 0, end = 0;
            for(int i = 0; i < sz; i++){
                Pair pair = queue.poll();
                TreeNode node = pair.node;
                int id = pair.id;
                if(i == 0){
                    start = id;
                }
                if(i == sz - 1){
                    end = id;
                }
                if(node.left != null){
                    queue.offer(new Pair(node.left, id * 2));
                }
                if(node.right != null){
                    queue.offer(new Pair(node.right, id * 2 + 1));
                }
            }
            maxWidth = Math.max(maxWidth, end - start + 1);
        }
        return maxWidth;
    }
}
