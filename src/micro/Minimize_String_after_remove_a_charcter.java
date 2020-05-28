package micro;

import common.Go;

public class Minimize_String_after_remove_a_charcter implements Go {

	@Override
	public void run() {
		// TODO Auto-generated method stub
//		3. ����һ�� string, �����ȥ��һ�� character��ʹ��ʣ�µ� string ��С��
//		������� acd��ȥ�� d ����ʣ�µ� ac ������ȷ�ġ���Ϊȥ�� c ���� ad��ȥ�� a ���� cd������ ac Ҫ
//		��
//		������� hot��ȥ�� t ����ʣ�µ� ho ������ȷ�ġ���Ϊȥ�� h ���� ot��ȥ�� o ���� ht������ ho Ҫ
//		��
//		������� aaaa��ֻҪ���� aaa ������ȷ��
		//Lexicographically Smallest String
		//https://leetcode.com/discuss/interview-question/366869/
		System.out.print(work("zabcde"));
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
			return s.substring(0, i) + s.substring(i+1, s.length());
		}
	}
}
