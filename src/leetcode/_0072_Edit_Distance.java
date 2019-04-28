package leetcode;

import common.Go;

public class _0072_Edit_Distance implements Go {

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] res = new int[m+1][n+1];
        for(int i = 0; i <= m; i++){
            for(int j = 0; j <= n; j++){
                if(i==0){
                    res[i][j] = j;
                    continue;
                }
                if(j==0){
                    res[i][j] = i;
                    continue;
                }
                res[i][j] = min(res[i][j-1]+1, res[i-1][j]+1, res[i-1][j-1]+1, word1.charAt(i-1) == word2.charAt(j-1) ? res[i-1][j-1] : Integer.MAX_VALUE);
            }
        }
        return res[m][n];
    }
    
    private int min(int i, int j, int k, int l){
        return Math.min(i, Math.min(j, Math.min(k, l)));
    }
}
