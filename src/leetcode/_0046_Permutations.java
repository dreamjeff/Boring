package leetcode;

import common.Go;
import java.util.*;

public class _0046_Permutations implements Go {

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        if(nums==null || nums.length==0) return res;
        dfs(nums, new boolean[nums.length], new LinkedList<>(), res);
        return res;
    }
    
    private void dfs(int[] nums, boolean[] used, List<Integer> subres, List<List<Integer>> res){
        if(subres.size() == nums.length){
            res.add(new LinkedList<>(subres));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(used[i]) continue;
            used[i] = true;
            subres.add(nums[i]);
            dfs(nums, used, subres, res);
            subres.remove(subres.size()-1);
            used[i] = false;
        }
    }
}
