package leetcode;

import common.Go;

public class _0048_Rotate_Image implements Go {

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

    public void rotate(int[][] matrix) {
        int l = 0, r = matrix.length-1, length = matrix.length;
        while(length>1){
            for(int i = 0; i < length-1; i++){
            	//watch the fixed column and row, find the pattern
                int tmp = matrix[l][l+i];
                matrix[l][l+i] = matrix[r-i][l];
                matrix[r-i][l] = matrix[r][r-i];
                matrix[r][r-i] = matrix[l+i][r];
                matrix[l+i][r] = tmp;
            }
            length -= 2;
            l++;
            r--;
        }
    }
}
