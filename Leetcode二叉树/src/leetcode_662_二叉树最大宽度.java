import java.util.Queue;
import java.util.LinkedList;
import java.util.Map;
import java.util.HashMap;

public class leetcode_662_二叉树最大宽度 {


 // 662. 二叉树最大宽度
 // 广度优先遍历
 /// 利用队列记录每一个节点，以及位置，深度（所以需要一个新的模型，把这些组合在一起）；深度用来检测当前层是否发生变化，对于当前层来说，当前节点的位置减去最左侧节点的位置，找到最大值就是当前层的宽度。
 // 左节点的位置为：父节点的位置 * 2
 // 右节点的位置为：父节点的位置 * 2 + 1
 // 宽度等于 ：右节点的位置 - 左节点的位置 + 1

class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null){
            return 0;
        }
        Queue<AnnotatedNode> queue = new LinkedList<AnnotatedNode>();
        queue.offer(new AnnotatedNode(root,0,0) );
        int currentDepth = 0;
        int left = 0;
        int res = 0;
        while (!queue.isEmpty()){
            AnnotatedNode node = queue.poll();
            if (node.node.left != null){
                queue.offer(new AnnotatedNode(node.node.left,node.depth+1,node.pos*2));
            }
            if (node.node.right != null){
                queue.offer(new AnnotatedNode(node.node.right,node.depth+1,node.pos*2+1));
            }
            if (currentDepth != node.depth){
                currentDepth = node.depth;
                left = node.pos;
            }

            res = Math.max(res,node.pos - left + 1);
        }
        return res;

    }
    
}
class AnnotatedNode{
    TreeNode node;
    int depth,pos;
    AnnotatedNode(TreeNode n,int d,int p){
        node = n;
        depth = d;
        pos = p;
    }
}


// 深度遍历，记录每层最左侧节点的深度和位置，然后最大宽度就出来了，和层序遍历的方式相同。

class Solution2 {
    int ans;
    Map<Integer, Integer> left;
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null){
            return ans;
        }
        left = new HashMap();
        in_widthOfBinaryTree(root,0,0);
        return ans;
    }

    void in_widthOfBinaryTree(TreeNode root,int depth,int pos){
        if (root == null) return;
        left.computeIfAbsent(depth, x-> pos);
        ans = Math.max(ans, pos - left.get(depth) + 1);
        in_widthOfBinaryTree(root.left,depth+1,pos *2);
        in_widthOfBinaryTree(root.right,depth+1,pos *2 + 1);
    }
}

}