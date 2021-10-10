import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;
public class leetcode_102_二叉树的层序遍历 {
	public List<List<Integer>> levelOrder(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        List<List<Integer>> res = new ArrayList();
        if (root == null){
            return res;
        }
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> inRes = new ArrayList<Integer>();
            while (size > 0){
                TreeNode node = queue.poll();
                if (node.left != null){
                    queue.offer(node.left);
                }
                if (node.right != null){
                    queue.offer(node.right);
                } 
                inRes.add(node.val);
                size = size - 1;
            }
            res.add(inRes);
        }
        return res;
    }
}
//class TreeNode {
//    int val;
//    TreeNode left;
//    TreeNode right;
//    TreeNode() {}
//    TreeNode(int val) { this.val = val; }
//    TreeNode(int val, TreeNode left, TreeNode right) {
//        this.val = val;
//        this.left = left;
//        this.right = right;   
//    }
//}