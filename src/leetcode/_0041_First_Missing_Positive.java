package leetcode;

import common.Go;

public class _0041_First_Missing_Positive implements Go {

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

    public int firstMissingPositive(int[] nums) {
        if(nums==null || nums.length==0) return 1;
        for(int i = 0; i < nums.length; i++){
        	/*nums[i]!=nums[nums[i]-1] can avoid infinity loop like [1,1], if the nums on the index is the
        	 * num should be there, the i = 0, nums[i] = 1, nums[i]-1 = 0, so nums[i] == nums[nums[i]-1] 
        	*/
            while(nums[i] > 0 && nums[i] < nums.length && nums[i]!=nums[nums[i]-1]){
                swap(nums, i, nums[i]-1);
            }
        }
        
        for(int i = 0; i < nums.length; i++){
            if(i!=nums[i]-1) return i+1;
        }
        return nums.length+1;
    }
    
    private void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
