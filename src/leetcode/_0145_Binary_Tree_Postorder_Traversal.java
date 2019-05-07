package leetcode;

import java.util.*;
import common.*;

public class _0145_Binary_Tree_Postorder_Traversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        dfs(root, res);
        return res;
    }
    
    private void dfs(TreeNode root, List<Integer> res){
        if(root == null) return;
        dfs(root.left, res);
        dfs(root.right, res);
        res.add(root.val);
    }
    //reverse as preorder
    public List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        while(!st.isEmpty()){
            TreeNode node = st.pop();
            if(node==null)continue;
            res.add(0, node.val);
            st.push(node.left);
            st.push(node.right);
        }
        return res;
    }
}
