package question5;

public class Main {
    class Triple{
        int row, col;
        TreeNode node;

        public Triple(TreeNode node, int row, int col){
            this.node = node;
            this.row = row;
            this.col = col;
        }
    }

    ArrayList<Triple> nodes = new ArrayList<>();

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        traverse(root, 0, 0);
        nodes.sort((Triple a, Triple b) ->{
            if(a.col == b.col && a.row == b.row){
                return a.node.val - b.node.val;
            }
            if(a.col == b.col){
                return a.row - b.row;
            }
            return a.col - b.col;
        });
        LinkedList<List<Integer>> res = new LinkedList<>();
        int preCol = Integer.MIN_VALUE;
        for(int i = 0; i < nodes.size(); i++){
            Triple cur = nodes.get(i);
            if(cur.col != preCol){
                res.addLast(new LinkedList<>());
                preCol = cur.col;
            }
            res.getLast().add(cur.node.val);
        }
        return res;
    }

    public void traverse(TreeNode root, int row, int col){
        if(root == null){
            return;
        }
        nodes.add(new Triple(root, row, col));
        traverse(root.left, row + 1, col - 1);
        traverse(root.right, row + 1, col + 1);
    }
}
