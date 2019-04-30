package leetcode;

import common.Go;
import java.util.*;

public class _0078_Subsets implements Go {

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

	//why the performance is better than combinations....
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        dfs(nums, 0, new LinkedList<>(), res);
        return res;
    }
    
    private void dfs(int[] nums, int index, List<Integer> subres, List<List<Integer>> res){
        res.add(new LinkedList<>(subres));
        for(int i = index; i < nums.length; i++){
            subres.add(nums[i]);
            dfs(nums, i+1, subres, res);
            subres.remove(subres.size()-1);
        }
    }
}
