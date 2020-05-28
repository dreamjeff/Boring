package micro;

import common.Go;
import java.lang.*;

public class Longest_Substring_Without_2_Contiguous_Occurrences_of_Letter implements Go {

	@Override
	public void run() {
		// TODO Auto-generated method stub
//https://leetcode.com/discuss/interview-question/398031/
//		Input: "aabbaaaaabb"
//			Output: "aabbaa"
//				
//				
//				Input: "aabbaabbaabbaa"
//					Output: "aabbaabbaabbaa"
		System.out.print(work("aabbaaaaabb"));
	}

	private String work(String s) {
		StringBuilder sb = new StringBuilder();
		int i=0, j=0;
		while(i<s.length()) {
			if(s.charAt(i)==s.charAt(j)) i++;
			else {
				if(i-j>2) {
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
			sb.append(s.charAt(j));
			sb.append(s.charAt(j));
		}else {
			while(j<i) {
				sb.append(s.charAt(j));
				j++;
			}
		}
		return sb.toString();
	}
}
