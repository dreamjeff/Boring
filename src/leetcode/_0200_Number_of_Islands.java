package leetcode;

public class _0200_Number_of_Islands {
    public int numIslands(char[][] grid) {
        int res = 0;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j]=='1'){
                    res++;
                    change(grid, i, j);
                }
            }
        }
        return res;
    }
    
    private void change(char[][] grid, int i, int j){
        if(i<0 || i==grid.length || j<0 || j==grid[0].length || grid[i][j]=='0') return;
        grid[i][j]='0';
        change(grid, i-1, j);
        change(grid, i+1, j);
        change(grid, i, j-1);
        change(grid, i, j+1);
    }
}
