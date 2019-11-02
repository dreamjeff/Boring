package micro;

import common.Go;
import java.lang.*;

public class Max_Possible_Value implements Go {

	@Override
	public void run() {
		// TODO Auto-generated method stub
//https://leetcode.com/discuss/interview-question/398050/
		System.out.print(work("0"));
	}

	private String work(String s) {
		StringBuilder sb = new StringBuilder();
		int i=0;
		if(s.charAt(0)=='-') {
			sb.append('-');
			i++;
			while(i<s.length()) {
				if(s.charAt(i)>='5') break;
				sb.append(s.charAt(i));
				i++;
			}
		}else {
			while(i<s.length()){
				if(s.charAt(i)<='5') break;
				sb.append(s.charAt(i));
				i++;
			}
		}
		sb.append('5');
		sb.append(s.substring(i));
		return sb.toString();

	}
}
