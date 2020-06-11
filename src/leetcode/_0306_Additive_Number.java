package leetcode;

import common.Go;

public class _0306_Additive_Number implements Go {

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

    public boolean isAdditiveNumber(String num) {
        for(int i=1; i<num.length(); i++){
            if(i>1&&num.charAt(0)=='0') return false;
            for(int j=i+1; j<=num.length(); j++){
                if(j==num.length() || (j>i+1&&num.charAt(i)=='0')) continue;
                if(find(num, j, new long[]{Long.valueOf(num.substring(0,i)), Long.valueOf(num.substring(i,j))}))
                    return true;
            }
        }
        return false;
    }
    
    private boolean find(String num, int index, long[] pre){
        if(index == num.length()) return true;
        if(index >num.length()) return false;
        for(int i=index+1; i<=num.length(); i++){
            if(i>index+1&&num.charAt(index)=='0') break;
            long cur=Long.valueOf(num.substring(index, i));
            if(cur==(pre[0]+pre[1])){
                pre[0]=pre[1];
                pre[1]=cur;
                if(find(num, i, pre)) return true;
                else break;
            }else if(cur>(pre[0]+pre[1])){
                break;   
            }
        }
        return false;
    }
}
