package leetcode;

import common.Go;

public class _0096_Unique_Binary_Search_Trees implements Go {

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

    int[] cache;
    public int numTrees(int n) {
        cache = new int[n+1];
        return help(n);
    }
    
    public int help(int n) {
        if(n==0) return 1;
        if(cache[n]!=0)return cache[n];
        int i = 1;
        int res = 0;
        while(i<=n){
            int left = help(i-1);
            int right = help(n-i);
            res += left*right;
            i++;
        }
        cache[n] = res;
        return res;
    }
    
    public int numTrees2(int n) {
        int[] cache = new int[n+1];
        cache[0] = 1;
        cache[1] = 1;
        for(int i = 2; i<=n; i++){
            for(int j = 1; j<=i; j++){
                cache[i] += cache[j-1]*cache[i-j];
            }
        }
        return cache[n];
    }
}
