package question6;

public class Main {
    public int countNodes(TreeNode root) {
        TreeNode l = root, r = root;
        int hl = 0, hr = 0;
        while(l != null){
            l = l.left;
            hl++;
        }
        while(r != null){
            r = r.right;
            hr++;
        }
        if(hl == hr){
            return (int)Math.pow(2, hl) - 1;
        }
        return countNodes(root.left) + countNodes(root.right) + 1;
    }
}
