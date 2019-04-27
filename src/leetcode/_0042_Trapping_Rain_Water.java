package leetcode;

import common.Go;

public class _0042_Trapping_Rain_Water implements Go {

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

    public int trap(int[] height) {
        int leftmax=0, rightmax=0, l = 0, r = height.length-1, res = 0;
        while(l<r){
            if(height[l] < height[r]){
                if(height[l] < leftmax){
                    res += leftmax-height[l];
                }else{
                    leftmax = Math.max(leftmax, height[l]);
                }
                l++;
            }else{
                if(height[r] < rightmax){
                    res += rightmax-height[r];
                }else{
                    rightmax = Math.max(rightmax, height[r]);
                }
                r--;
            }
        }
        return res;
    }
}
