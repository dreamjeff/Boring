package leetcode;

import common.*;
import java.util.*;

public class _0105_Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal implements Go {

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
    }
    
    private TreeNode build(int[] preorder, int pl, int pr, int[] inorder, int inl, int inr){
        if(pl>pr)return null;
        TreeNode node = new TreeNode(preorder[pl]);
        if(pl==pr) return node;
        int i = inl;
        while(i <= inr){
            if(inorder[i] == node.val) break;
            i++;
        }
        node.left = build(preorder, pl+1, pl+i-inl, inorder, inl, i-1);
        node.right = build(preorder, pl+i-inl+1, pr, inorder, i+1, inr);
        return node;
    }
}
