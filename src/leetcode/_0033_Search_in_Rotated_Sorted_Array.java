package leetcode;

import common.Go;

public class _0033_Search_in_Rotated_Sorted_Array implements Go {

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

    public int search(int[] nums, int target) {
        int l = 0, r = nums.length-1;
        while(l <= r){
            int mid = l + (r-l)/2;
            if(nums[mid] == target) return mid;
            //three scenario
            if(nums[l] < nums[r]){
                if(nums[mid] > target){
                    r = mid-1;
                }else{
                    l = mid+1;
                }
            }else if(nums[mid] < nums[r]){
                if(target > nums[mid] && target <= nums[r]){
                    l = mid+1;
                }else{
                    r = mid-1;
                }
            }else{//nums[mid] > nums[r]
                if(target >= nums[l] && target < nums[mid]){
                    r = mid-1;
                }else{
                    l = mid+1;
                }
            }
        }
        return -1;
    }
}
