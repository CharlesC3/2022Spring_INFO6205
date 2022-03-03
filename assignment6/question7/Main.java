package question7;

public class Main {
    StringBuilder path = new StringBuilder();
    int res = 0;

    public int sumNumbers(TreeNode root) {
        traverse(root);
        return res;
    }

    public void traverse(TreeNode root){
        if(root == null){
            return;
        }
        path.append(root.val);
        if(root.left == null && root.right == null){
            res += Integer.parseInt(path.toString());
        }
        traverse(root.left);
        traverse(root.right);
        path.deleteCharAt(path.length() - 1);
    }
}
