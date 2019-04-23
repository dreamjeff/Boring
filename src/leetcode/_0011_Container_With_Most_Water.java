package leetcode;

import common.Go;

public class _0011_Container_With_Most_Water implements Go {

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

    public int maxArea(int[] height) {
        int res = 0;
        int i = 0, j = height.length-1;
        while(i < j) {
        	int min = Math.min(height[i], height[j]);
        	res = Math.max(res, min*(j-i));
        	if(height[i]<height[j]) {
        		i++;
        	}else {
        		j--;
        	}
        }
        return res;
    }
}
