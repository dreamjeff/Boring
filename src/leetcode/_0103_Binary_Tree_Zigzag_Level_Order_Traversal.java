package leetcode;

import common.*;
import java.util.*;

public class _0103_Binary_Tree_Zigzag_Level_Order_Traversal implements Go {

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if(root==null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean dir = true;
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> subres = new LinkedList<>();
            while(size-->0){
                TreeNode node = q.poll();
                if(dir){
                    subres.add(node.val);
                }else{
                    subres.add(0, node.val);
                }
                if(node.left!=null) q.add(node.left);
                if(node.right!=null) q.add(node.right);
            }
            res.add(subres);
            dir = !dir;
        }
        return res;
    }
}
