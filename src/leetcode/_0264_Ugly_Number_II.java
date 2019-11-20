package leetcode;

import common.Go;

public class _0264_Ugly_Number_II implements Go {

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}
    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        dp[0]=1;
        int cur=1;
        int n2=0, n3=0, n5=0;
        while(cur<n){
            int i2=dp[n2]*2, i3=dp[n3]*3, i5=dp[n5]*5;
            int min = Math.min(Math.min(i2, i3), i5);
            dp[cur]=min;
            if(min==i2) n2++;
            if(min==i3) n3++;
            if(min==i5) n5++;
            cur++;
        }
        return dp[n-1];
    }
}
