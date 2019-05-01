package leetcode;

import common.Go;

public class _0081_Search_in_Rotated_Sorted_Array_II implements Go {

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

    public boolean search(int[] nums, int target) {
        if(nums==null || nums.length==0) return false;
        int l = 0, r = nums.length-1;
        while(l<r){
            while(l<r && nums[l]==nums[r]) r--;
            int mid = l+(r-l)/2;
            if(nums[mid]==target) return true;
            if(nums[l]<nums[r]){//watch the pattern, classify the scenario
                if(nums[mid]<target){
                    l = mid+1;
                }else{
                    r = mid-1;
                }
            }else if(nums[mid]<=nums[r]){// watch the =, if r==mid, needs to be included here
                if(nums[mid] < target && nums[r] >= target){
                    l = mid+1;
                }else{
                    r = mid-1;
                }
            }else{//nums[mid]>numd[r]
                if(nums[mid]>target && target >= nums[l]){
                    r = mid-1;
                }else{
                    l = mid+1;
                }
            }
        }
        if(nums[l] == target) return true;
        return false;
    }
}
