package leetcode;

import common.Go;

public class _0132_Palindrome_Partitioning_II implements Go {

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}
    public int minCut(String s) {
        int[] dp = new int[s.length()];
        for(int i=0; i<s.length(); i++){
            dp[i]=i;
        }
        for(int i=0; i<s.length(); i++){
            isPalin(s, i, i, dp);
            isPalin(s, i, i+1, dp);
        }
        return dp[s.length()-1];
    }
    
    private void isPalin(String s, int i, int j, int[] dp){
        while(i>=0 && j <s.length() && s.charAt(i)==s.charAt(j)){
            if(i==0){
                dp[j]=0;
            }else{
                dp[j] = Math.min(dp[j], dp[i-1]+1);   
            }
            i--;
            j++;
        }
    }
}
