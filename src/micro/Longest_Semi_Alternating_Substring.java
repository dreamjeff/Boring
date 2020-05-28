package micro;

import common.Go;
import java.lang.*;

public class Longest_Semi_Alternating_Substring implements Go {

	@Override
	public void run() {
		// TODO Auto-generated method stub
//		 ��һ���ַ�����Ҫ��ɾ�����ٵ��ַ���ʹ���ַ����в��������������һ�����ַ�������
//		 bbbbbbaccccc ҪΪ bbacc��
		System.out.print(work("abaabbbaa"));
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
