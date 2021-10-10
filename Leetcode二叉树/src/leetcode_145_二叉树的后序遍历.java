import java.util.ArrayList;
import java.util.List;
import java.util.Deque;
import java.util.LinkedList;
public class leetcode_145_二叉树的后序遍历 {
	 public List<Integer> postorderTraversal(TreeNode root) {
		 List<Integer>res = new ArrayList<Integer>();
		 postorder(root,res);
		 return res;
	 }
	 public void postorder(TreeNode root,List<Integer>res) {
		 if (root == null) {
			 return;
		 }
		 postorder(root.left,res);
		 postorder(root.right,res);
		 res.add(root.val);
	 }
	 /// 迭代
	 public List<Integer> postorderTraversal2(TreeNode root) {
		 List<Integer>res = new ArrayList<Integer>();
		 Deque<TreeNode> stack = new LinkedList<TreeNode>();
		 TreeNode node = root;
		 while(!stack.isEmpty() || node != null) {
			 while (node != null) {
				 stack.push(node);
				 node = node.left;
			 }
			 node = stack.pop();
			 node = node.right;
			 res.add(node.val);
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