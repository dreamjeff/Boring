package leetcode;

import common.Go;
import java.util.*;

public class _0310_Minimum_Height_Trees implements Go {

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

    HashMap<Integer, List<Integer>> map;
    int maxDepth = Integer.MAX_VALUE;
    int curDepth = 0;
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        map = new HashMap<>();
        for(int i=0; i<edges.length; i++){
            if(map.containsKey(edges[i][0])){
                map.get(edges[i][0]).add(edges[i][1]);
            }else{
                List<Integer> l = new LinkedList<>();
                l.add(edges[i][1]);
                map.put(edges[i][0], l);
            }
            if(map.containsKey(edges[i][1])){
                map.get(edges[i][1]).add(edges[i][0]);
            }else{
                List<Integer> l = new LinkedList<>();
                l.add(edges[i][0]);
                map.put(edges[i][1], l);
            }
        }
        List<Integer> res = new LinkedList<>();
        for(int i=0; i<n; i++){
            curDepth=0;
            if(find(i, -1, 1)){
                if(curDepth<maxDepth) res.clear();
                res.add(i);
                maxDepth=curDepth;
            }
        }
        return res;
    }
    
    private boolean find(int node, int pre, int depth){
        if(depth>curDepth) curDepth=depth;
        if(curDepth>maxDepth) return false;
        List<Integer> l = map.get(node);
        if(l==null||l.size()==0) return true;
        for(Integer i : l){
            if(i==pre) continue;
            if(!find(i, node, depth+1)) return false;
        }
        return true;
    }
    
    public List<Integer> findMinHeightTrees2(int n, int[][] edges) {
        if (n == 1) return Collections.singletonList(0);
        List<Integer> leaves = new ArrayList<>();
        List<Set<Integer>> adj = new ArrayList<>(n);
        for (int i = 0; i < n; ++i) adj.add(new HashSet<>());
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        for (int i = 0; i < n; ++i) {
            if (adj.get(i).size() == 1) leaves.add(i);
        }
        while (n > 2) {
            n -= leaves.size();
            List<Integer> newLeaves = new ArrayList<>();
            for (int i : leaves) {
                int t = adj.get(i).iterator().next();
                adj.get(t).remove(i);
                if (adj.get(t).size() == 1) newLeaves.add(t);
            }
            leaves = newLeaves;
        }
        return leaves;
    }
}
