package micro;

import common.Go;

public class Largest_alphabetically_order implements Go {

	@Override
	public void run() {
		// TODO Auto-generated method stub
//		1. ֻ�д�д��Сд��ĸ��ɣ�Ҫ�󷵻�һ����д��ĸ��which is the largest alphabetically order
//		and occurs both in lower and upper cases in the string��
//		����"aAbxeEX"��A��E�� X ���������⣬�� X ����ĸ��Ƚϴ����Է��� X��

		System.out.print(work("aAbxeEX"));
	}

	private char work(String s) {
		int diff = 'a'-'A';
		char res = 'A'-1;
		boolean[] chars = new boolean[128];
		for(char c : s.toCharArray()) {
			if(c<'a') {
				chars[c]=true;
				if(chars[c+diff]) {
					res = c>res?c:res;
				}
			}else {
				chars[c]=true;
				if(chars[c-diff]) {
					res = (c-diff)>res?(char)(c-diff):res;
				}
			}
		}
		return res;
	}
}
