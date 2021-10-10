import java.util.ArrayList;
import java.util.List;
import java.util.Deque;
import java.util.LinkedList;

public class leetcode_144__二叉树的前序遍历 {
	/// 递归法
	class Solution {
	    public List<Integer> preorderTraversal(TreeNode root) {
	        List<Integer> res = new ArrayList<Integer>();
	        preorder(root,res);
	        return res;
	    }

	    public void preorder(TreeNode root,List<Integer> res){
	        if (root == null){
	            return;
	        }
	        res.add(root.val);
	        preorder(root.left,res);
	        preorder(root.right,res);
	    }
	}
	/// 迭代法
	// 遇到节点就push到栈中，节点左边的处理完了，出栈，处理节点右边的
	public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) {
            return res;
        }

        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        TreeNode node = root;
        while (!stack.isEmpty() || node != null){
            while(node != null){
                res.add(node.val);
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            node = node.right;
        }
        return res;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;   
    }
}