package leetcode;

import common.Go;

public class _0063_Unique_Paths_II implements Go {

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[] map = new int[n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(i == 0){
                    if(j == 0){
                        map[j] = obstacleGrid[i][j] == 1 ? 0 : 1;
                    }else{
                        map[j] = obstacleGrid[i][j] == 1 ? 0 : map[j-1];
                    }
                }else{
                    if(j == 0){
                        map[j] = obstacleGrid[i][j] == 1 ? 0 : map[j];
                    }else{
                        map[j] = obstacleGrid[i][j] == 1 ? 0 : map[j-1] + map[j];
                    }
                }
            }
        }
        return map[n-1];
    }
}
