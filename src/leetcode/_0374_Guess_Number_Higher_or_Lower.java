package leetcode;

import common.Go;

public class _0374_Guess_Number_Higher_or_Lower implements Go {
	
	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

    public int guessNumber(int n) {
        int i=1, j=n;
        while(i<=j){
            int num = i+(j-i)/2;
            int res = guess(num);
            if(res==0) return num;
            if(res==-1) j=num-1;
            if(res==1) i=num+1;
        }
        return i;
    }
    
	/** 
	 * Forward declaration of guess API.
	 * @param  num   your guess
	 * @return 	     -1 if num is lower than the guess number
	 *			      1 if num is higher than the guess number
	 *               otherwise return 0
	 * int guess(int num);
	 */
    private int guess(int num) {
    	return 0;
    }
}
