package leetcode;

import common.Go;

public class _0075_Sort_Colors implements Go {

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

	// watch if you swap 2 to the end, the swapped item may needs to swap again if it is 0
    public void sortColors(int[] nums) {
        int r = 0, b = nums.length-1, p = 0;
        while(p <= b){
            if(nums[p] == 1) p++;
            else if(nums[p] == 0){
                swap(nums, p++, r++);
            }else if(nums[p] == 2){
                swap(nums, p, b--);
            }
        }
    }
    
    private void swap(int[] nums, int i , int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
