package am;

import common.Go;
import java.util.*;

public class LongestParentheses implements Go {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("longestValidParentheses : " + longestValidParentheses("((()()())"));
	}

	public int longestValidParentheses(String s) {
		int start = 0;
		int res = 0;
		String sRes = "";
		Stack<Integer> st = new Stack<Integer>();
		for(int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if(c == '(') st.push(i);
			else if(c == ')'){
				if(st.isEmpty()) start = i+1;
				else {
					st.pop();
					res = st.isEmpty() ? Math.max(res, i - start + 1) : Math.max(res, i - st.peek());
					sRes = s.substring(i - res + 1, i + 1);
				}
			}
		}
		System.out.println(sRes);
		return res;
	}
}
