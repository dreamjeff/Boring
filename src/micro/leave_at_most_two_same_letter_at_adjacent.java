package micro;

import common.Go;
import java.lang.*;

public class leave_at_most_two_same_letter_at_adjacent implements Go {

	@Override
	public void run() {
		// TODO Auto-generated method stub
//		�����ַ���, ���ش������ַ����������ظ��������ַ�������2
//		ֻ��Сд
//		input: xxxbcddde
//		output: xxbcdde
		System.out.print(work("aaa"));
	}
	
	private String work(String s) {
		StringBuffer sb = new StringBuffer();
		int i=0, j=0;
		while(i<s.length()) {
			if(s.charAt(i)==s.charAt(j)) i++;
			else {
				sb.append(s.charAt(j));
				if((i-j)>1) sb.append(s.charAt(j));
				j=i;
			}
		}
		if(j<s.length())sb.append(s.charAt(j));
		if((i-j)>1) sb.append(s.charAt(j));
		return sb.toString();
	}

}
