import java.util.LinkedList;
// https://leetcode-cn.com/problems/invert-binary-tree
	
public class leetcode_226_翻转二叉树 {
	// 递归
	class Solution {
	    public TreeNode invertTree(TreeNode root) {
	        if (root == null){
	            return root;
	        }
	        TreeNode node1 = invertTree(root.left);
	        TreeNode node2 = invertTree(root.right);

	        root.left = node2;
	        root.right = node1;
	        return root;
	    }
	}
	// 队列 + 广度优先遍历
	class Solution2 {
	    public TreeNode invertTree(TreeNode root) {
	        if (root == null){
	            return root;
	        }
	        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
	        queue.offer(root);
	        while(!queue.isEmpty()){
	            TreeNode curr = queue.poll();
	            TreeNode left = curr.left;
	            TreeNode right = curr.right;
	            curr.left = right;
	            curr.right = left;
	            if (left != null){
	                queue.offer(left);   
	            }
	            if (right != null){
	                queue.offer(right);
	            }
	        }
	        return root;
	    }
	}
}
