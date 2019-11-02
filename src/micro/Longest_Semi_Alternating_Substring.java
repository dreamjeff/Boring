package micro;

import common.Go;
import java.lang.*;

public class Longest_Semi_Alternating_Substring implements Go {

	@Override
	public void run() {
		// TODO Auto-generated method stub
//		 给一个字符串，要求删减最少的字符，使得字符串中不会出现连续三个一样的字符，比如
//		 bbbbbbaccccc 要为 bbacc。
		System.out.print(work("abaaaa"));
	}

	private String work(String s) {
		int i=0, j=0, res=0;
		StringBuilder sb = new StringBuilder();
		while(i<s.length()) {
			if(s.charAt(i)==s.charAt(j)) i++;
			else {
				if(i-j>2) {
					res+=i-j-2;
					sb.append(s.charAt(j));
					sb.append(s.charAt(j));
				}else {
					while(j<i) {
						sb.append(s.charAt(j));
						j++;
					}
				}
				j=i;
			}
		}
		if(i-j>2) {
			res+=i-j-2;
			sb.append(s.charAt(j));
			sb.append(s.charAt(j));
		}else {
			while(j<i) {
				sb.append(s.charAt(j));
				j++;
			}
		}
		System.out.println(res);
		return sb.toString();
	}
}
