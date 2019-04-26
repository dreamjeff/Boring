package leetcode;

import common.Go;
import java.util.*;

public class _0036_Valid_Sudoku implements Go {

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

    public boolean isValidSudoku(char[][] board) {
        HashSet<Character> set = new HashSet<>();
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board.length; j++){
                if(board[i][j] == '.') continue;
                if(set.contains(board[i][j])) return false;
                set.add(board[i][j]);
            }
            set.clear();
        }
        
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board.length; j++){
                if(board[j][i] == '.') continue;
                if(set.contains(board[j][i])) return false;
                set.add(board[j][i]);
            }
            set.clear();
        }
        
        int size = board.length/3;
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                for(int x = i*size; x < (i+1)*size; x++){
                    for(int y = j*size; y < (j+1)*size; y++){
                        if(board[x][y] == '.') continue;
                        if(set.contains(board[x][y])) return false;
                        set.add(board[x][y]);
                    }
                }
                set.clear();
            }
        }
        return true;
    }
}
