package question3;

public class Main {
    public static void main(String[] args) {
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        constructTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public static TreeNode constructTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd){
        if(preStart > preEnd){
            return null;
        }
        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);
        int index = 0;
        for(int i = 0; i < inorder.length; i++){
            if(inorder[i] == rootVal){
                index = i;
                break;
            }
        }
        int leftSize = index - inStart;
        root.left = constructTree(preorder, preStart + 1, preStart + leftSize, inorder, inStart, index - 1);
        root.right = constructTree(preorder, preStart + leftSize + 1, preEnd, inorder, index + 1,inEnd);
        return root;
    }
}
