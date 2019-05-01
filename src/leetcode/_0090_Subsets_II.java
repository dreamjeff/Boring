package leetcode;

import common.Go;
import java.util.*;

public class _0090_Subsets_II implements Go {

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        if(nums==null || nums.length==0) return res;
        Arrays.sort(nums);
        dfs(nums, 0, res, new LinkedList<>());
        return res;
    }
    
    public void dfs(int[] nums, int index, List<List<Integer>> res, List<Integer> subres){
        res.add(new LinkedList<>(subres));
        for(int i = index; i<nums.length; i++){
            if(i > index && nums[i] == nums[i-1]){//why use index, why no need to judge whether the previous one is used?
                continue;
            }
            subres.add(nums[i]);
            dfs(nums, i+1, res, subres);
            subres.remove(subres.size()-1);
        }
    }
}
