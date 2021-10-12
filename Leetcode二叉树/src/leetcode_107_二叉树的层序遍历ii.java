import java.util.Queue;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;

public class leetcode_107_二叉树的层序遍历ii {
	class Solution {
	    public List<List<Integer>> levelOrderBottom(TreeNode root) {
	        List<List<Integer>> ret = new LinkedList<List<Integer>>();
	        if (root == null){
	            return ret;
	        }
	        Queue<TreeNode> queue = new LinkedList<TreeNode>();
	        queue.offer(root);
	        while(!queue.isEmpty()){
	            int size = queue.size();
	            List<Integer> inRet = new ArrayList<Integer>();
	            while(size > 0){
	                TreeNode node = queue.poll();
	                if (node.left != null){
	                    queue.offer(node.left);
	                }
	                if (node.right != null){
	                    queue.offer(node.right);
	                }
	                inRet.add(node.val);
	                size--;
	            }
	            ret.add(0, inRet);
	        }
	        return ret;
	    }
	}
}
