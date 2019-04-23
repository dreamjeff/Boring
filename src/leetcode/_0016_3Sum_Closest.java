package leetcode;

import common.Go;
import java.util.*;

public class _0016_3Sum_Closest implements Go {

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = nums[0] + nums[1] + nums[2];
        for(int i = 0; i < nums.length -2; i++){
            int j = i+1, k=nums.length-1;
            while(j<k){
                int sum = nums[i] + nums[j] + nums[k];
                if(Math.abs(sum-target) < Math.abs(res-target)){
                    res = sum;
                }
                if(sum > target){
                    k--;
                }else if(sum < target){
                    j++;
                }else{
                    return res;
                }
            }
        }
        return res;
    }
}
