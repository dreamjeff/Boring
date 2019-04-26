package leetcode;

import common.Go;
import java.util.*;

public class _0040_Combination_Sum_II implements Go {

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new LinkedList<>();
        if(candidates==null || candidates.length==0) return res;
        Arrays.sort(candidates);
        dfs(0, target, candidates, res, new LinkedList<>(), 0, new boolean[candidates.length]);
        return res;
    }
    
    private void dfs(int sum, int target, int[] candidates, List<List<Integer>> res, List<Integer> subres, int index, boolean[] used){
        if(sum > target) return;
        if(sum == target){
            res.add(new ArrayList<>(subres));
        }
        for(int i = index; i<candidates.length; i++){
            if(i > 0 && candidates[i]==candidates[i-1] && !used[i-1]) continue;
            int j = candidates[i];
            used[i] = true;
            sum += j;
            subres.add(j);
            dfs(sum, target, candidates, res, subres, i+1, used);
            used[i] = false;
            sum -= j;
            subres.remove(subres.size()-1);
        }
    }
}
