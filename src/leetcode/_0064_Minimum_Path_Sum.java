package leetcode;

import common.Go;

public class _0064_Minimum_Path_Sum implements Go {

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] map = new int[n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(i==0){
                    if(j==0){
                        map[j] = grid[i][j];
                    }else{
                        map[j] = grid[i][j] + map[j-1];
                    }
                }else{
                    if(j==0){
                        map[j] = map[j] + grid[i][j];
                    }else{
                        map[j] = Math.min(map[j-1], map[j]) + grid[i][j];
                    }
                }
            }
        }
        return map[n-1];
    }
}
