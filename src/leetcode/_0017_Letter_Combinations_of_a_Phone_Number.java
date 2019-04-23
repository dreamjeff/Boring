package leetcode;

import common.Go;
import java.util.*;

public class _0017_Letter_Combinations_of_a_Phone_Number implements Go {

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

    public List<String> letterCombinations(String digits) {
        char c = 'a';
        char[][] num = new char[8][4];
        for(int i = 0; i < num.length; i++){
            for(int j = 0; j < num[i].length; j++){
                if(j == 3 && i!=5 && i!=7) continue;//i is the real number -2, so 7 is 5, 9 is 7
                num[i][j] = c;
                c++;
            }
        }
        List<String> res = new LinkedList<>();
        if(digits==null||digits.length()==0) return res;
        dfs(digits, 0, res, "", num);
        return res;
    }
    
    private void dfs(String digits, int index, List<String> res, String subres, char[][] num){
        if(index == digits.length()){
            res.add(new String(subres));
            return;
        }
        int n = digits.charAt(index)-'0'-2;
        for(char c : num[n]){
            if(c-'a' > 26 || c-'a' < 0) continue;
            subres  = subres + c;
            dfs(digits, index+1, res, subres, num);
            subres = subres.substring(0, subres.length()-1);
        }
    }
}
