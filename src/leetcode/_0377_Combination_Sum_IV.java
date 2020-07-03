package leetcode;

import common.Go;

public class _0377_Combination_Sum_IV implements Go {

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target+1];
        dp[0]=1;
        for(int i=1; i<dp.length; i++){
            for(int j : nums){
                if(i>=j) dp[i]+=dp[i-j];
            }
        }
        return dp[target];
    }
}
