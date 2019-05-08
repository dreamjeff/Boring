package leetcode;

import common.*;
import java.util.*;

public class _0199_Binary_Tree_Right_Side_View implements Go {

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        find(root, 1, res);
        return res;
    }
    
    private void find(TreeNode root, int level, List<Integer> res){
        if(root == null) return;
        if(level > res.size()){
            res.add(root.val);
        }
        find(root.right, level+1, res);
        find(root.left, level+1, res);
    }
}
