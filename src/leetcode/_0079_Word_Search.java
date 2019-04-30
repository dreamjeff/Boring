package leetcode;

import common.Go;

public class _0079_Word_Search implements Go {

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

	//not sure why exceed time limit in leetcode
    public boolean exist(char[][] board, String word) {
        if(word==null) return true;
        if(board==null) return false;
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(find(board, word, i, j, 0)) return true;
            }
        }
        return false;
    }
    
    private boolean find(char[][] board, String word, int i, int j, int index){
        if(index == word.length()) return true;
        if(i<0 || i >= board.length || j<0 || j>=board[0].length || board[i][j] != word.charAt(index)) return false;
        char c = board[i][j];
        board[i][j] = '.';
        boolean up = find(board, word, i-1, j, index+1);
        boolean down = find(board, word, i+1, j, index+1);
        boolean left = find(board, word, i, j-1, index+1);
        boolean right = find(board, word, i, j+1, index+1);
        board[i][j] = c;
        return up||down||left||right;
    }
}
