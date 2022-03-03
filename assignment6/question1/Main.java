package question1;

public class Main {
    HashMap<Integer, Integer> preSumCount = new HashMap<>();
    int pathSum, targetSum;
    int res = 0;
    public int pathSum(TreeNode root, int targetSum) {
        if(root == null){
            return 0;
        }
        pathSum = 0;
        this.targetSum = targetSum;
        preSumCount.put(0, 1);
        traverse(root);
        return res;
    }

    public void traverse(TreeNode root){
        if(root == null){
            return;
        }
        pathSum += root.val;
        res += preSumCount.getOrDefault(pathSum - targetSum, 0);
        preSumCount.put(pathSum, preSumCount.getOrDefault(pathSum, 0) + 1);
        traverse(root.left);
        traverse(root.right);
        preSumCount.put(pathSum, preSumCount.get(pathSum) - 1);
        pathSum -= root.val;
    }
}
