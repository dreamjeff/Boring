package micro;

import common.Go;

public class Max_Inserts_to_Obtain_String_Without_3_Consecutive_a implements Go {

	@Override
	public void run() {
		// TODO Auto-generated method stub
//https://leetcode.com/discuss/interview-question/398056/
		System.out.print(work("dog"));
	}

	private int work(String s) {
		int i=0, j=0, res=0;
		while(i<s.length()) {
			if(s.charAt(i)=='a') i++;
			else {
				if(i-j>2) return -1;
				else {
					if(i-j==0) res+=2;
					if(i-j==1) res+=1;
					i++;
					j=i;
				}
			}
		}
		if(i-j>2) return -1;
		if(i-j==0) res+=2;
		if(i-j==1) res+=1;
		return res;
	}
}
