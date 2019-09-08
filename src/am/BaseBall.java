package am;

import java.util.*;

import common.Go;

public class BaseBall implements Go{
//	Given a string array representing a throw ball blocks, each string is either a number,
//
//	+, Z, X. Calculate total. If number, just add to total. If +, add last 2 scores to total.
//	If Z, remove last score from total. If X, double last score and add to toal.
//	Use 0 for any missing last score. ��Щ corner cases Ҫ���ǡ�
//	�����÷֣�����һ��String[] input��������score
//	����� integer�� �ͼӸ�score���и�ֵ��
//	����ǡ�x��, ����һ��ֵdouble ���Ӹ�score�� ��û����һ��ֵ����һ��ֵ��0 ����
//	����ǡ�z��, ��һ���ɼ����ϣ� score ������һֵ
//	����ǡ�+������������ֵ��ӣ�Ȼ��Ӹ�score
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
		Integer val = 0;
		if(!st.isEmpty() && s.charAt(0) == 'Z') {
			val = st.pop();
			res -= val;
		}else if(!st.isEmpty() && s.charAt(0) == 'X') {
			val = st.peek() * 2;
			res += val;
			st.push(val);
		}else if(s.charAt(0) == '+') {
			if(st.size()>=2) {
				 Integer pre = st.pop();
				 val = pre + st.peek();
				 st.push(pre);
			}else if(st.size()==1) {
				val = st.peek();
			}
			st.push(val);
			res += val;
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
