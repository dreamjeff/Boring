package leetcode;

import common.Go;

public class _0080_Remove_Duplicates_from_Sorted_Array_II implements Go {

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

	// Find the pattern on the question. the pattern here is the l position and the relation with 2 or x if remove more.
    public int removeDuplicates(int[] nums) {
        int l = 0, r = 0;
        while(r < nums.length){
            if(l < 2 || nums[l-2] < nums[r]){
                nums[l] = nums[r];
                l++;
            }
            r++;
        }
        return l;
    }
}
