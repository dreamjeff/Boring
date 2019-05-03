package leetcode;

import common.*;

public class _0114_Flatten_Binary_Tree_to_Linked_List implements Go {

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

    TreeNode tail;
    public void flatten(TreeNode root) {
        if(root==null) return;
        flatten(root.right);
        flatten(root.left);
        root.right = tail;
        tail = root;
        root.left = null;
    }
    
    //this way needs to be remember better, it is reverse from the previous one
    public void flatten2(TreeNode root) {
        if(root==null) return;
        while(root.left!=null || root.right!=null){
            if(root.left==null){
                root = root.right;
            }else{
                TreeNode hold = root.right;
                root.right = root.left;
                root.left=null;
                root = root.right;
                TreeNode cur = root;
                while(cur.right!=null){
                    cur = cur.right;
                }
                cur.right = hold;
            }
        }
    }
}
