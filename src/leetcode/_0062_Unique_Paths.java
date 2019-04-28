package leetcode;

import common.Go;

public class _0062_Unique_Paths implements Go {

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

    public int uniquePaths(int m, int n) {
        int[] map = new int[m];//one array can reduce space
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(i == 0){
                    map[j] = 1;
                }else{
                    if(j>0){
                        map[j] += map[j-1];
                    }
                }
            }
        }
        return map[m-1];
    }
}
