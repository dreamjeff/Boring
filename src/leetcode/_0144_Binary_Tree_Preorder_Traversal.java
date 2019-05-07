package leetcode;

import common.*;
import java.util.*;

public class _0144_Binary_Tree_Preorder_Traversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        dfs(root, res);
        return res;
    }
    
    private void dfs(TreeNode root, List<Integer> res){
        if(root == null) return;
        res.add(root.val);
        dfs(root.left, res);
        dfs(root.right, res);
    }
    
    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        while(!st.isEmpty()){
            TreeNode node = st.pop();
            if(node==null) continue;
            res.add(node.val);
            st.push(node.right);
            st.push(node.left);
        }
        return res;
    }
}
