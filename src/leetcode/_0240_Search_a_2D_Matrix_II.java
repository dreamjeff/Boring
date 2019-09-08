package leetcode;

public class _0240_Search_a_2D_Matrix_II {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix==null || matrix.length==0 || matrix[0].length==0)
            return false;
        int m = matrix.length-1, n = matrix[0].length-1;
        int x = m, y = 0;
        while(x>=0 && y <=n){
            if(matrix[x][y]==target) return true;
            if(matrix[x][y]>target){
                if(x>0){
                    x--;
                }else{
                    break;
                }
            }else{
                if(y<n){
                    y++;
                }else{
                    break;
                }
            }
        }
        return false;
    }
}
