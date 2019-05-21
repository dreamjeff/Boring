package leetcode;

public class _0518_Coin_Change_2 {
    public int change(int amount, int[] coins) {
        int[][] sum = new int[coins.length+1][amount+1];
        for(int i=0; i<=coins.length; i++){
            for(int j=0; j<=amount; j++){
                if(j==0){
                    sum[i][j]=1;
                    continue;
                }
                if(i>0){
                    sum[i][j] = sum[i-1][j] + (j-coins[i-1]>=0?sum[i][j-coins[i-1]]:0);
                }
            }
        }
        return sum[coins.length][amount];
    }
}
