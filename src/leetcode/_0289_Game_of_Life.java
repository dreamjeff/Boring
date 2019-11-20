package leetcode;

import common.Go;

public class _0289_Game_of_Life implements Go {

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}
    //2 is 0 to 1
    //3 is 1 to 0
	public void gameOfLife(int[][] board) {
	    for(int i=0; i<board.length; i++){
	        for(int j=0; j<board[0].length; j++){
	            check(i, j, board);
	        }
	    }
	    for(int i=0; i<board.length; i++){
	        for(int j=0; j<board[0].length; j++){
	            if(board[i][j]==2) board[i][j]=1;
	            if(board[i][j]==3) board[i][j]=0;
	        }
	    }
	}
	
	private void check(int i, int j, int[][] board){
	    int liveNeighbors = 0;
	    int deadNeighbors = 0;
	    for(int x=i-1; x<=i+1; x++){
	        for(int y=j-1; y<=j+1; y++){
	            if(x==i&&y==j) continue;
	            if(x<0||x>=board.length||y<0||y>=board[0].length) continue;
	            int cur = board[x][y];
	            if(cur==0 || cur==2){
	                deadNeighbors++;
	            }else{
	                liveNeighbors++;
	            }
	        }
	    }
	    int cur = board[i][j];
	    if(cur==1){
	        if(liveNeighbors<2 || liveNeighbors>3) board[i][j]=3;
	    }else{
	        if(liveNeighbors==3) board[i][j]=2;
	    }
	}
}
