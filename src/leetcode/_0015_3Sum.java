package leetcode;

import common.Go;
import java.util.*;

public class _0015_3Sum implements Go {

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        Arrays.sort(nums);
        for(int i  = 0; i < nums.length - 2; i++){
            if(i > 0 && nums[i] == nums[i-1]) continue;
            int j = i+1, k = nums.length-1;
            while(j < k){
                int sum = nums[i] + nums[j] + nums[k];
                if(sum == 0){
                    List<Integer> subres = new LinkedList<>();
                    subres.add(nums[i]);
                    subres.add(nums[j]);
                    subres.add(nums[k]);
                    res.add(subres);
                    while(j<k && nums[j] == nums[j+1])j++;
                    while(j<k && nums[k] == nums[k-1])k--;
                    j++;
                    k--;
                }else if(sum < 0){
                    j++;
                }else if(sum > 0){
                    k--;
                }
            }
        }
        return res;
    }
}
