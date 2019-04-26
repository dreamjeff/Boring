package leetcode;

import common.Go;

public class _0034_Find_First_and_Last_Position_of_Element_in_Sorted_Array implements Go {

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

    public int[] searchRange(int[] nums, int target) {
        if(nums==null || nums.length==0) return new int[]{-1,-1};
        int first = findFirst(nums, target);
        if(nums[first]!=target) return new int[]{-1,-1};
        return new int[]{first, findLast(nums, target)};
    }
    
    private int findFirst(int[] nums, int target){
        int l = 0, r = nums.length-1;
        while(l < r){
            int mid = l + (r-l)/2;
            if(nums[mid] == target){
                r = mid;
            }else if(nums[mid] > target){
                r = mid-1;
            }else if(nums[mid] < target){
                l = mid+1;
            }
        }
        return l;
    }
    
    private int findLast(int[] nums, int target){
        int l = 0, r = nums.length-1;
        while(l < r){
            int mid = l + (r-l)/2 + 1;
            if(nums[mid] == target){
                l = mid;
            }else if(nums[mid] > target){
                r = mid-1;
            }else if(nums[mid] < target){
                l = mid+1;
            }
        }
        return l;
    }
}
