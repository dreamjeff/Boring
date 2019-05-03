package leetcode;

import common.*;

public class _0106_Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal implements Go {

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1);
    }
    
    private TreeNode build(int[] inorder, int inl, int inr, int[] postorder, int pol, int por){
        if(pol>por) return null;
        TreeNode node = new TreeNode(postorder[por]);
        if(pol==por) return node;
        int i = inl;
        while(i<=inr){
            if(inorder[i]==node.val) break;
            i++;
        }
        node.left = build(inorder, inl, i-1, postorder, pol, pol+i-inl-1);
        node.right = build(inorder, i+1, inr, postorder, pol+i-inl, por-1);
        return node;
    }
}
