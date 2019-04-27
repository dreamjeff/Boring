package leetcode;

import common.Go;
import java.util.*;

public class _0039_Combination_Sum implements Go {

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new LinkedList<>();
        if(candidates==null || candidates.length==0) return res;
        dfs(0, target, candidates, res, new LinkedList<>(), 0);
        return res;
    }
    
    //index here can be used as to achieve duplicate on current index but not duplicate the number before this index
    private void dfs(int sum, int target, int[] candidates, List<List<Integer>> res, List<Integer> subres, int index){
        if(sum > target){
            return;
        }
        if(sum == target){
            res.add(new ArrayList<Integer>(subres));
        }
        for(int j = index; j<candidates.length; j++){
            int i = candidates[j];
            sum += i;
            subres.add(i);
            dfs(sum, target, candidates, res, subres, j);
            sum -= i;
            subres.remove(subres.size()-1);
        }
    }
}
