import java.util.ArrayList;
import java.util.List;
import java.util.Deque;
import java.util.LinkedList;

public class leetcode_94_二叉树的中序遍历 {
	// 递归
	public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        inorder(root,res);
        return res;
    }
    public void inorder(TreeNode root,List<Integer> res){
        if (root == null){
	        return;
	    }
        inorder(root.left,res);
        res.add(root.val);
        inorder(root.right,res);
    }
    // 迭代
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        TreeNode node = root;
        while (!stack.isEmpty() || node != null) {
        	while(node != null) {
        		stack.push(node);
        		node = node.left;
        	}
        	node = stack.pop();
        	res.add(node.val);
        	node = node.right;
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