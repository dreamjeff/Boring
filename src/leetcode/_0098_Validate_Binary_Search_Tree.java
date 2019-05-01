package leetcode;

import common.*;

public class _0098_Validate_Binary_Search_Tree implements Go {

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

    public boolean isValidBST(TreeNode root) {
        return isValid(root, null, null);
    }
    
    private boolean isValid(TreeNode root, Integer min, Integer max){
        if(root==null) return true;
        if(min!=null && root.val<=min) return false;
        if(max!=null && root.val >= max) return false;
        return isValid(root.left, min, root.val) && isValid(root.right, root.val, max);
    }
}
