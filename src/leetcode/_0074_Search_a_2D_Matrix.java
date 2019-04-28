package leetcode;

import common.Go;

public class _0074_Search_a_2D_Matrix implements Go {

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix==null || matrix.length==0 || matrix[0].length==0) return false;
        int length = matrix.length * matrix[0].length;
        int wide = matrix[0].length;//watch this, it is not matrix.length!!
        int l = 0, r = length-1;
        while(l <= r){
            int mid = l + (r-l)/2;
            int index1 = mid/wide;
            int index2 = mid%wide;
            if(matrix[index1][index2] == target) return true;
            if(matrix[index1][index2] > target){
                r = mid-1;
            }else{
                l = mid+1;
            }
        }
        return false;
    }
}
