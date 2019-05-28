package am;

import java.util.*;

import common.Go;

public class BaseBall implements Go{
	
	public void run() {
		List<String> scores = new ArrayList<>();
		scores.add("5");
		scores.add("-2");
		scores.add("4");
		scores.add("Z");
		scores.add("X");
		scores.add("9");
		scores.add("+");
		scores.add("+");
		System.out.println(score(scores));
	}
	
	int res = 0;
	
	public int score(List<String> scores) {
		Stack<Integer> st = new Stack<>();
		for(String s : scores) {
			thisGame(s, st);
			//System.out.println(res);
		}
		return res;
	}
	
	private void thisGame(String s, Stack<Integer> st) {
		if(s.charAt(0) == 'Z') {
			res -= st.pop();
		}else if(s.charAt(0) == 'X') {
			Integer pre = st.pop();
			res += pre + pre;
			st.push(pre + pre);
		}else if(s.charAt(0) == '+') {
			Integer pre = st.pop();
			Integer add = pre + st.peek();
			res += add;
			st.push(pre);
			st.push(add);
		}else {
			int t = 1;
			int sub = 0;
			int a = 1;
			for(int i = s.length()-1; i >=0; i--) {
				if(s.charAt(i) == '-') {
					t = -1;
					continue;
				}
				sub += (s.charAt(i)-'0')*a;
				a *= 10;
			}
			sub *= t;
			//System.out.println("sub:" + sub);
			res += sub;
			st.push(sub);
		}
	}
}
