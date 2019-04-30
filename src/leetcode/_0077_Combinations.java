package leetcode;

import common.Go;
import java.util.*;

public class _0077_Combinations implements Go {

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

	//Not sure why it is not fast
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new LinkedList<>();
        dfs(1, n, k, res, new LinkedList<>());
        return res;
    }
    
    private void dfs(int index, int n, int k, List<List<Integer>> res, List<Integer> subres){
        if(subres.size() == k){
            res.add(new LinkedList<>(subres));
            return;
        }
        for(int i = index; i <= n; i++){
            subres.add(i);
            dfs(i+1, n, k, res, subres);
            subres.remove(subres.size()-1);
        }
    }
}
