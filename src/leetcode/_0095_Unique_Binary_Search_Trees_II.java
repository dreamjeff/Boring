package leetcode;

import common.*;
import java.util.*;

public class _0095_Unique_Binary_Search_Trees_II implements Go {

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

    public List<TreeNode> generateTrees(int n) {
        if(n < 1) return new LinkedList<>();
        return help(1, n);
    }
    
    private List<TreeNode> help(int l, int r){
        List<TreeNode> res = new LinkedList<>();
        if(l>r){
            res.add(null);//watch the null, can't return null list
            return res;
        }
        for(int i = l; i<=r; i++){
            List<TreeNode> lefts = help(l, i-1);
            List<TreeNode> rights = help(i+1, r);
            for(TreeNode lNode : lefts){
                for(TreeNode rNode : rights){
                    TreeNode node = new TreeNode(i);
                    node.left = lNode;
                    node.right = rNode;
                    res.add(node);
                }
            }
        }
        return res;
    }
}
