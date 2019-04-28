package leetcode;

import common.Go;

public class _0073_Set_Matrix_Zeroes implements Go {

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

    public void setZeroes(int[][] matrix) {
    	/*Don't process the first row and column, otherwise it will impact the result.
    	 * Don't change the number during iteration, otherwise it will impact the rest of array*/
        boolean rowHas0 = false, columnHas0 = false;
        for(int i = 0; i < matrix.length; i++){
            if(matrix[i][0] == 0) columnHas0 = true;
        }
        for(int j = 0; j < matrix[0].length; j++){
            if(matrix[0][j] == 0) rowHas0 = true;
        }
        for(int i = 1; i < matrix.length; i++){
            for(int j = 1; j < matrix[0].length; j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for(int i = 1; i < matrix.length; i++){
            if(matrix[i][0] == 0){
                for(int j = 1; j < matrix[0].length; j++){
                    matrix[i][j] = 0;
                }
            }
        }
        for(int j = 1; j < matrix[0].length; j++){
            if(matrix[0][j] == 0){
                for(int i = 1; i < matrix.length; i++){
                    matrix[i][j] = 0;
                }
            }
        }
        if(columnHas0){
            for(int i = 0; i < matrix.length; i++){
                matrix[i][0] = 0;
            }
        }
        if(rowHas0){
            for(int j = 0; j < matrix[0].length; j++){
                matrix[0][j] = 0;
            }
        }
    }
}
