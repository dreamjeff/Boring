package leetcode;

import common.Go;

public class _0031_Next_Permutation implements Go {

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

    public void nextPermutation(int[] nums) {
        for(int i = nums.length-2; i >= 0; i--){
            if(nums[i] < nums[i+1]){
                for(int j = nums.length-1; j > i ; j--){
                    if(nums[j] > nums[i]){
                        swap(nums, i, j);
                        sort(nums, i+1, nums.length-1);
                        return;
                    }
                }
            }
        }
        sort(nums, 0, nums.length-1);
    }
    
    private void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    
    private void sort(int[] nums, int i, int j){
        while(i < j){
            swap(nums, i, j);
            i++;
            j--;
        }
    }
}
