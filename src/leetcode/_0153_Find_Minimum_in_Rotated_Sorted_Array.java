package leetcode;

import common.Go;

public class _0153_Find_Minimum_in_Rotated_Sorted_Array implements Go {

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}
    public int findMin(int[] nums) {
        int l = 0, r = nums.length-1;
        while(l<r){
            int m = l+(r-l)/2;
            if(nums[l]<nums[r]) return nums[l];
            if(nums[m]<nums[l]){
                r = m;
            }else{
                l = m+1;
            }
        }
        return nums[l];
    }
}
