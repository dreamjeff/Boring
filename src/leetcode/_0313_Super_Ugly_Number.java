package leetcode;

import common.Go;
import java.util.*;

public class _0313_Super_Ugly_Number implements Go {

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

    public int nthSuperUglyNumber(int n, int[] primes) {
        if(n==1) return 1;
        int[][] cur = new int[primes.length][2];
        List<Integer> ugly = new ArrayList<>();
        for(int i=0; i<cur.length; i++){
            cur[i][0]=0;cur[i][1]=primes[i];
        }
        int res = 1;
        while(n>1){
            int min=Integer.MAX_VALUE;
            for(int i=0; i<cur.length; i++){
                min = Math.min(min, cur[i][1]);
            }
            ugly.add(min);
            for(int i=0; i<cur.length; i++){
                if(cur[i][1]==min){
                    cur[i][0]+=1;
                    cur[i][1] = ugly.get(cur[i][0]-1)*primes[i];
                } 
            }
            n--;
        }
        return ugly.get(ugly.size()-1);
    }
}
