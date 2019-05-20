package leetcode;

import java.util.*;
import common.*;

public class _0742_Closest_Leaf_in_a_Binary_Tree {
    /**
     * @param root: the root
     * @param k: an integer
     * @return: the value of the nearest leaf node to target k in the tree
     */
     
    private HashMap<TreeNode, TreeNode> map = new HashMap<>();
     
    public int findClosestLeaf(TreeNode root, int k) {
        // Write your code here
        TreeNode nodeK = buildMap(root, null, k);
        Queue<TreeNode> q = new LinkedList<>();
        HashSet<TreeNode> visted = new HashSet<>();
        q.add(nodeK);
        while(!q.isEmpty()){
            int size = q.size();
            while(size-->0){
                TreeNode node = q.poll();
                if(node.left==null&&node.right==null) return node.val;
                visted.add(node);
                if(node.left!=null && !visted.contains(node.left)){
                    q.add(node.left);
                }
                if(node.right!=null && !visted.contains(node.right)){
                    q.add(node.right);
                }
                if(map.get(node)!=null && !visted.contains(map.get(node))){
                    q.add(map.get(node));
                }
            }
        }
        return -1;
    }

    private TreeNode buildMap(TreeNode root, TreeNode pre, int k){
        if(root==null) return null;
        map.put(root, pre);
        if(root.val == k) return root;
        TreeNode left = buildMap(root.left, root, k);
        TreeNode right = buildMap(root.right, root, k);
        return left==null?right:left;
    }
}
