package leetcode;

import common.Go;
import java.util.*;

public class _0018_4Sum implements Go {

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new LinkedList<>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length-3; i++){
            if(i > 0 && nums[i] == nums[i-1]) continue;
            for(int j = i+1; j < nums.length-2; j++){
                if(j > i+1 && nums[j] == nums[j-1]) continue;
                int subsum = nums[i] + nums[j];
                int x = j+1, y = nums.length-1;
                while(x<y){
                    int sum = subsum + nums[x] + nums[y];
                    if(sum == target){
                        List<Integer> l = new LinkedList<>();
                        l.add(nums[i]);l.add(nums[j]);l.add(nums[x]);l.add(nums[y]);
                        res.add(l);
                        while(x<y && nums[x] == nums[x+1]) x++;
                        while(x<y && nums[y] == nums[y-1]) y--;
                        x++;
                        y--;
                    }else if(sum > target){
                        y--;
                    }else if(sum < target){
                        x++;
                    }
                }
            }
        }
        return res;
    }
}
