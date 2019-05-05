package leetcode;

import common.*;

public class _0129_Sum_Root_to_Leaf_Numbers implements Go {

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}
    int res = 0;
    public int sumNumbers(TreeNode root) {
        find(root, 0);
        return this.res;
    }
    
    private void find(TreeNode root, int subsum){
        if(root==null) return;
        subsum = subsum*10+root.val;
        if(root.left==null&&root.right==null){
            this.res += subsum;
            return;
        }
        if(root.left!=null) find(root.left, subsum);
        if(root.right!=null) find(root.right, subsum);
    }
}
