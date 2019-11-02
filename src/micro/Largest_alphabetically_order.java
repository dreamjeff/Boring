package micro;

import common.Go;

public class Largest_alphabetically_order implements Go {

	@Override
	public void run() {
		// TODO Auto-generated method stub
//		1. 只有大写和小写字母组成，要求返回一个大写字母，which is the largest alphabetically order
//		and occurs both in lower and upper cases in the string。
//		比如"aAbxeEX"，A，E， X 都符合题意，但 X 的字母序比较大，所以返回 X。

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
