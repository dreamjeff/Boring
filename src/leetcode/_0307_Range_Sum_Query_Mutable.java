package leetcode;

import common.Go;

public class _0307_Range_Sum_Query_Mutable implements Go {

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

    int[] nums;
    public _0307_Range_Sum_Query_Mutable(int[] nums) {
        this.nums = nums;
    }
    
    public void update(int i, int val) {
        if(i<0||i>=nums.length) return;
        nums[i]=val;
    }
    
    public int sumRange(int i, int j) {
        int end = j<=nums.length?j:nums.length-1;
        int res=0;
        for(int x=i; x<=end; x++){
            res+=nums[x];
        }
        return res;
    }
}
