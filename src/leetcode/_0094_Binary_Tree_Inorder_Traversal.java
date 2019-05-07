package leetcode;

import common.*;
import java.util.*;

public class _0094_Binary_Tree_Inorder_Traversal implements Go {

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        dfs(root, res);
        return res;
    }
    
    public void dfs(TreeNode root, List<Integer> res){
        if(root == null) return;
        dfs(root.left, res);
        res.add(root.val);
        dfs(root.right, res);
    }
    
    // how to convert to preorder and postorder
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if(root==null) return res;
        Stack<TreeNode> st = new Stack<>();
        TreeNode p = root;
        while(!st.isEmpty() || p!=null){
            if(p!=null){
                st.push(p);
                p = p.left;
            }else{
                p = st.pop();
                res.add(p.val);
                p = p.right;
            }
        }
        return res;
    }
}
