package am;

import java.util.*;

import common.Go;

public class BstDistance implements Go{
	
//	给一个无序integer array，要求用insert的方法建一个BST，然后给出其
//
//	中两个值在树上的距离，若是有不在树里的，返回-1
//	解题思路参考：
//	千万注意这是一道大题！坑：首先给的integer array可能是有序的，就不需要排序了，否则可能会有case不过。
//	再次是BST，不要按照BinaryTree搞，会超时导致case不过。解题思路，先建BST，再做LCA，然后算两点和root的距离（level）。 
//	geekforgeek上的解释：http://www.geeksforgeeks.org/find-distance-two-given-nodes/
	
	private class TreeNode{
		public int val;
		public TreeNode left;
		public TreeNode right;
		public TreeNode(int val) {
			this.val = val;
		}
	}
	
	public void run() {
		List<Integer> nodes = new ArrayList<>();
		nodes.add(5);
		nodes.add(6);
		nodes.add(3);
		nodes.add(1);
		nodes.add(2);
		nodes.add(4);
		System.out.println(bstDistance(nodes, 6, 2));
	}
	
	public int bstDistance(List<Integer> nodes, int node1, int node2) {
		TreeNode root = new TreeNode(nodes.get(0));
		for(int i = 1; i < nodes.size(); i++) {
			TreeNode node = new TreeNode(nodes.get(i));
			insertNode(root, node);
		}
		TreeNode ancestor = commonAncestor(node1, node2, root);
		return findDistance(node1, ancestor, 0) + findDistance(node2, ancestor, 0);
	}
	
	private void insertNode(TreeNode root, TreeNode node) {
		if(root.val > node.val) {
			if(root.left == null) {
				root.left = node;
			}else {
				insertNode(root.left, node);
			}
		}else {
			if(root.right == null) {
				root.right = node;
			}else {
				insertNode(root.right, node);
			}
		}
	}
	
	private TreeNode commonAncestor(int node1, int node2, TreeNode root) {
		if(node1 > node2) {
			int tmp = node1;
			node1 = node2;
			node2 = tmp;
		}
		if(root.val > node1 && root.val < node2 || root.val == node1 || root.val == node2) {
			return root;
		}else if(root.val > node1 && root.val > node2) {
			return commonAncestor(node1, node2, root.left);
		}else {
			return commonAncestor(node1, node2, root.right);
		}
	}
	
	private int findDistance(int node, TreeNode root, int res) {
		if(root.val == node) return res;
		if(root.val > node) {
			return findDistance(node, root.left, res+1);
		}else {
			return findDistance(node, root.right, res+1);
		}
	}
}

