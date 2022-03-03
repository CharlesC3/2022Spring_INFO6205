package question4;

public class Main {
    String SEP = ",";
    String NULL = "#";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null){
            return "";
        }
        StringBuilder s = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node == null){
                s.append(NULL).append(SEP);
                continue;
            }
            s.append(node.val).append(SEP);
            queue.offer(node.left);
            queue.offer(node.right);
        }
        return s.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.isEmpty()){
            return null;
        }
        String[] node = data.split(SEP);
        TreeNode root = new TreeNode(Integer.parseInt(node[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        for(int i = 1; i < node.length;){
            TreeNode parent = queue.poll();
            String left = node[i++];
            if(!left.equals(NULL)){
                parent.left = new TreeNode(Integer.parseInt(left));
                queue.offer(parent.left);
            }else{
                parent.left = null;
            }

            String right = node[i++];
            if(!right.equals(NULL)){
                parent.right = new TreeNode(Integer.parseInt(right));
                queue.offer(parent.right);
            }else{
                parent.right = null;
            }
        }
        return root;
    }
}
