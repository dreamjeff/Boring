package leetcode;

import common.Go;
import java.util.*;

public class _0022_Generate_Parentheses implements Go {

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

    public List<String> generateParenthesis(int n) {
        List<String> res = new LinkedList<>();
        dfs(res, "", n, n);
        return res;
    }
    
    private void dfs(List<String> res, String s, int l, int r){
        if(l < 0 || r < 0 || l > r) return;
        if(l == 0 && r == 0){
            res.add(new String(s));
        }
        dfs(res, s+"(", l-1, r);
        dfs(res, s+")", l, r-1);
    }
}
