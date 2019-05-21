package leetcode;

public class _0322_Coin_Change {
    public int coinChange(int[] coins, int amount) {
        int[] sum = new int[amount+1];
        for(int i=1; i<=amount; i++){
            sum[i] = Integer.MAX_VALUE;
            for(int j=0; j<coins.length; j++){
                if(i-coins[j]>=0 && sum[i-coins[j]]!=Integer.MAX_VALUE){
                    sum[i] = Math.min(sum[i], sum[i-coins[j]]+1);
                }
            }
        }
        return sum[amount]==Integer.MAX_VALUE?-1:sum[amount];
    }
}
