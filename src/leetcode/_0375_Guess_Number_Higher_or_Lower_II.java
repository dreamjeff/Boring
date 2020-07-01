package leetcode;

import common.Go;

public class _0375_Guess_Number_Higher_or_Lower_II implements Go {

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

    public int getMoneyAmount(int n) {
        int [][] dp = new int[n+1][n+1];
        for(int len = 2; len<=n; len++){
            for(int start = 1; start<=n-len+1; start++){
                int minPay = Integer.MAX_VALUE;
                for(int pivot = start; pivot < start+len-1; pivot++){
                    int temp = pivot + Math.max(dp[start][pivot-1], dp[pivot+1][start+len-1]);
                    minPay = Math.min(minPay, temp);
                }
                dp[start][start+len-1] = minPay;
            }
        }
        return dp[1][n];
   }
}
