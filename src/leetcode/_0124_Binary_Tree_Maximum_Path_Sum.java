package leetcode;

import common.*;

public class _0124_Binary_Tree_Maximum_Path_Sum {
    int res = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        max(root);
        return res;
    }
    
    private int max(TreeNode root){
        if(root==null) return 0;
        int left = Math.max(max(root.left), 0);
        int right = Math.max(max(root.right), 0);
        this.res = Math.max(this.res, root.val+left+right);
        return root.val + Math.max(left, right);
    }
}
