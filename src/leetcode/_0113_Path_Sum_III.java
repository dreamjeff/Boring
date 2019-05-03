package leetcode;

import common.*;
import java.util.*;

public class _0113_Path_Sum_III implements Go {

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new LinkedList<>();
        find(root, sum, res, new LinkedList<>(), 0);
        return res;
    }
    
    private void find(TreeNode root, int sum, List<List<Integer>> res, List<Integer> subres, int subsum){
        if(root == null){
            return;
        }
        subres.add(root.val);
        subsum+=root.val;
        if(root.left==null && root.right==null && subsum==sum){
            res.add(new LinkedList<>(subres));
            subres.remove(subres.size()-1);
            return;
        }
        find(root.left, sum, res, subres, subsum);
        find(root.right, sum, res, subres, subsum);
        subres.remove(subres.size()-1);
    }
}
