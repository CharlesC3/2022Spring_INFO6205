package question2;

public class Main {
    List<List<Integer>> list = new ArrayList<>();
    public List<List<Integer>> findLeaves(TreeNode root) {
        maxDepth(root);
        return list;
    }

    public int maxDepth(TreeNode root){
        if(root == null){
            return 0;
        }
        int h = Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;

        if(list.size() < h){
            list.add(new ArrayList<>());
        }
        list.get(h - 1).add(root.val);
        return h;
    }
}
