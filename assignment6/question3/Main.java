package question3;

public class Main {
    int res = 0;
    public int longestUnivaluePath(TreeNode root) {
        if(root == null){
            return 0;
        }
        maxLen(root, root.val);
        return res;
    }

    public int maxLen(TreeNode root, int parentVal){
        if(root == null){
            return 0;
        }
        int leftLen = maxLen(root.left, root.val);
        int rightLen = maxLen(root.right, root.val);
        res = Math.max(res, leftLen + rightLen);
        if(root.val != parentVal){
            return 0;
        }
        return Math.max(leftLen, rightLen) + 1;
    }
}
