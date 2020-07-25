
package micro;

import common.Go;

public class Min_Moves_to_Obtain_String_Without_3_Identical_Consecutive_Letters implements Go {

	@Override
	public void run() {
		// TODO Auto-generated method stub
//https://leetcode.com/discuss/interview-question/398026/
		//baaaaa
		//baaabbaabbba
		//baabab
		System.out.print(work("baaaaa"));
	}

	private int work(String s) {
		int i=0, j=0, res=0;
		while(i<s.length()) {
			if(s.charAt(i)==s.charAt(j)) i++;
			else {
				if(i-j>2) {
					res+=(i-j)/3;
				}
				j=i;
			}
		}
		if(i-j>2) {
			res+=(i-j)/3;
		}
		return res;
	}
}
