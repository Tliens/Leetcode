
import java.util.Queue;
import java.util.LinkedList;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
//https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/

public class leetcode_589_N叉树的前序遍历 {


class Solution {
    
    /// 递归
    public List<Integer> preorder(Node root) {
        List<Integer> ret = new ArrayList<Integer>();
        in_preorder(ret,root);
        return ret;
    }

    void in_preorder(List<Integer> ret,Node root){
        if (root == null){
            return;
        }
        ret.add(root.val);
        for (int i = 0; i < root.children.size() ; i++){
            in_preorder(ret,root.children.get(i));
        }
    }
}

class Solution2 {
    
    /// 递归
    public List<Integer> preorder(Node root) {
        List<Integer> ret = new ArrayList<Integer>();
        in_preorder(ret,root);
        return ret;
    }

    void in_preorder(List<Integer> ret,Node root){
        if (root == null){
            return;
        }
        ret.add(root.val);
        for (int i = 0; i < root.children.size() ; i++){
            in_preorder(ret,root.children.get(i));
        }
    }
}
}
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};