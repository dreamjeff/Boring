package leetcode;

import common.Go;

public class _0378_Kth_Smallest_Element_in_a_Sorted_Matrix implements Go {

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

	class Solution {
	    public int kthSmallest(int[][] matrix, int k) {
	        int left=matrix[0][0], right=matrix[matrix.length-1][matrix[0].length-1];
	        while(left<right){
	            int mid = left + (right-left)/2;
	            int cnt = find(matrix, mid);
	            if(cnt<k) left = mid+1;
	            else right = mid-1;
	        }
	        return left;
	    }
	    
	    private int find(int[][] matrix, int mid){//find how many number smaller than mid
	        int res = 0, i=matrix.length-1, j=0;
	        while(i>=0 && j<matrix[0].length){
	            if(matrix[i][j]<=mid){
	                res+=i+1;
	                j++;
	            }else{
	                i--;
	            }
	        }
	        return res;
	    }
}
