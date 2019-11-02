package micro;

import common.Go;
import java.util.*;

public class Min_Steps_to_Make_Piles_Equal_Height implements Go {

	@Override
	public void run() {
		// TODO Auto-generated method stub
//https://leetcode.com/discuss/interview-question/364618/
		//new int[]{5,2,1}
		//new int[]{4,5,5,4,2}
		System.out.print(work(new Integer[]{4,5,5,4,2}));
	}

	private int work(Integer[] a) {
		Arrays.sort(a, Collections.reverseOrder());
		int step=0;
		for(int i=1; i<a.length; i++) {
			if(a[i]<a[i-1]) {
				step+=i;
			}
		}
		return step;
	}
}
