package micro;

import common.Go;

public class Minimize_String_after_remove_a_charcter implements Go {

	@Override
	public void run() {
		// TODO Auto-generated method stub
//		3. 给定一个 string, 问如何去掉一个 character，使得剩下的 string 最小。
//		比如给出 acd，去掉 d 返回剩下的 ac 就是正确的。因为去掉 c 留下 ad，去掉 a 留下 cd，都比 ac 要
//		大。
//		比如给出 hot，去掉 t 返回剩下的 ho 就是正确的。因为去掉 h 留下 ot，去掉 o 留下 ht，都比 ho 要
//		大。
//		比如给出 aaaa，只要返回 aaa 就是正确的
		//Lexicographically Smallest String
		//https://leetcode.com/discuss/interview-question/366869/
		System.out.print(work("aaaa"));
	}

	private String work(String s) {
		if(s.length()==1) return "";
		int i=0;
		while(i<s.length()-1) {
			if(s.charAt(i)>s.charAt(i+1)) break;
			i++;
		}
		if(i==s.length()-1) {
			return s.substring(0, i);
		}else {
			return s.substring(0, i-1) + s.substring(i+1, s.length());
		}
	}
}
