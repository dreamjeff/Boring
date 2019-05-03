package leetcode;

import common.*;
import java.util.*;

public class _0102_Binary_Tree_Level_Order_Traversal implements Go {

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if(root==null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> subres = new LinkedList<>();
            while(size-->0){
                TreeNode node = q.poll();
                subres.add(node.val);
                if(node.left!=null) q.add(node.left);
                if(node.right!=null) q.add(node.right);
            }
            res.add(subres);
        }
        return res;
    }
}
