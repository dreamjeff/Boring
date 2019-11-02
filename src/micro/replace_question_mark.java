package micro;

import common.Go;

public class replace_question_mark implements Go {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.print(work("??a??b?b?"));
	}

	private String work(String s) {
		char[] res = s.toCharArray();
		int i=0, j=-1;
		while(i<s.length()) {
			System.out.println(res[i]);
			if(res[i]=='?') i++;
			else {
				if(i-j>1) {
					System.out.println("do");
					char a1 = (char)(((res[i]-'a'+1)%26)+'a');
					System.out.println(a1);
					char a2 = 'a';
					if(j==-1) {
						a2 = (char)(((res[i]-'a'+2)%26)+'a');
					}else {
						a2 = res[i]==res[j]?(char)(((res[i]-'a'-1)%26)+'a'):(char)(((res[j]-res[i]+7)%26)+'a');
					}
					System.out.println(a2);
					j++;
					while(j<i) {
						if(j%2==0) {
							res[j] = a1;
						}else {
							res[j] = a2;
						}
						j++;
					}
					i++;
				}else {
					i++;
					j++;
				}
			}
		}
		if(i-j>1) {
			char a1 = (char)(((res[j]-'a'+1)%26)+'a');
			char a2 = (char)(((res[j]-'a'-1)%26)+'a');
			j++;
			while(j<i) {
				if(j%2==0) {
					res[j] = a1;
				}else {
					res[j] = a2;
				}
				j++;
			}
		}
		return new String(res);
	}
	
}
