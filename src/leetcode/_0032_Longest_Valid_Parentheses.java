package leetcode;

import common.Go;
import java.util.*;

public class _0032_Longest_Valid_Parentheses implements Go {

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

    public int longestValidParentheses(String s) {
        Stack<Integer> st = new Stack<>();
        int start = 0;
        int res = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '('){
                st.push(i);
            }else{
                if(st.isEmpty()){
                    start = i+1;
                }else{
                    res = Math.max(res, i - st.pop()+1);
                    if(st.isEmpty()){
                        res = Math.max(res, i - start + 1);
                    }else{
                        res = Math.max(res, i - st.peek());//For scenario like (()()
                    }
                }
            }
        }
        return res;
    }
}
