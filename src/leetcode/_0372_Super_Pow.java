package leetcode;

import common.Go;

public class _0372_Super_Pow implements Go {

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

    public int superPow(int a, int[] b) {
        int res=1;
        for(int i=0; i<b.length; i++){
            res = pow(res, 10) * pow(a, b[i]) % 1337;
        }
        return res;
    }
    
    private int pow(int x, int n){
        if(n==0) return 1;
        if(n==1) return x%1337;
        return pow(x%1337, n/2) * pow(x%1337, n-n/2) % 1337;
    }
}
