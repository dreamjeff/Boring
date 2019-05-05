package leetcode;

import common.Go;

public class _0130_Surrounded_Regions implements Go {

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}
    public void solve(char[][] board) {
        for(int i = 0; i<board.length; i++){
            for(int j = 0; j<board[0].length; j++){
                if(i==0||i==board.length-1||j==0||j==board[0].length-1){
                    if(board[i][j]=='O') change(board, i, j);
                }
            }
        }
        for(int i = 0; i < board.length;i++){
            for(int j = 0; j<board[0].length; j++){
                if(board[i][j]=='O') board[i][j] = 'X';
                if(board[i][j]=='#') board[i][j] = 'O';
            }
        }
    }
    
    private void change(char[][] board, int i, int j){
        if(i<0||i==board.length||j<0||j==board[0].length||board[i][j]=='X'||board[i][j]=='#'){
            return;
        }
        board[i][j] = '#';
        change(board, i-1, j);
        change(board, i+1, j);
        change(board, i, j-1);
        change(board, i, j+1);
    }
}
