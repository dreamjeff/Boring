package leetcode;

import common.Go;
import java.util.*;

public class _0368_Largest_Divisible_Subset implements Go {

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}
	
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int[] dp=new int[nums.length];
        int[] parent=new int[nums.length];
        int mx=0, mx_indx=0;
        for(int i=nums.length-1; i>=0; i--){
            for(int j=i; j<nums.length; j++){
                if(nums[j]%nums[i]==0 && dp[i]<dp[j]+1){
                    dp[i] = dp[j]+1;
                    parent[i]=j;
                    if(mx<dp[i]){
                        mx=dp[i];
                        mx_indx=i;
                    }
                }
            }
        }
        List<Integer> res = new LinkedList<>();
        while(mx>0){
            res.add(nums[mx_indx]);
            mx_indx=parent[mx_indx];
            mx--;
        }
        return res;
    }
}
