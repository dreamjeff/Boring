package am;

import java.util.*;

import common.Go;

public class ScoreGathering implements Go{
	
	public void run() {
		List<Integer> list = new ArrayList<Integer>();
		list.add(4);
		list.add(2);
		list.add(5);
		list.add(5);
		list.add(6);
		list.add(1);
		list.add(4);
		System.out.println(scoreGathering(list));
	}
	
	public String scoreGathering(List<Integer> list) {
		List<TreeNode> l = new ArrayList<>();
		HashMap<Integer, TreeNode> m = new HashMap<>();
		for(Integer i : list) {
			if(m.containsKey(i)) {
				m.get(i).count++;
			}else {
				TreeNode node = new TreeNode(i);
				l.add(node);
				m.put(i, node);
			}
		}
		
		TreeNode root = l.get(0);
		for(TreeNode node : l) {
			if(root == node) continue;
			buildBST(root, node);
		}
		
		return bfs(root);
	}
	
	private String bfs(TreeNode root) {
		StringBuilder sb = new StringBuilder();
		Queue<TreeNode> q = new LinkedList<>();
		q.offer(root);
		while(!q.isEmpty()) {
			int size = q.size();
			while(size>0) {
				TreeNode node = q.poll();
				sb.append(node.val + ":" + node.count + ",");
				if(node.left!=null) q.offer(node.left);
				if(node.right!=null) q.offer(node.right);
				size--;
			}
		}
		sb.setLength(sb.length()-1);
		return sb.toString();
	}
	
	private void buildBST(TreeNode root, TreeNode node) {
		if(root.val > node.val) {
			if(root.left == null) {
				root.left = node;
			}else {
				buildBST(root.left, node);
			}
		}else {
			if(root.right == null) {
				root.right = node;
			}else {
				buildBST(root.right, node);
			}
		}
	}
	
	private class TreeNode{
		public int val;
		public int count;
		public TreeNode left;
		public TreeNode right;
		public TreeNode(int val) {
			this.val = val;
			count = 1;
		}
	}
}
