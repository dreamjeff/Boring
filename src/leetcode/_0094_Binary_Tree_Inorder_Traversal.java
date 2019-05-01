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
}
