package micro;

import common.Go;
import java.util.*;

public class Max_Network_Rank implements Go {

	@Override
	public void run() {
		// TODO Auto-generated method stub
//https://leetcode.com/discuss/interview-question/364760/
		//new int[]{1,2,3,3}, new int[]{2,3,1,4}, 4
		//new int[]{1,2,4,5}, new int[]{2,3,5,6}, 6
		System.out.print(work(new int[]{1,2,3,3}, new int[]{2,3,1,4}, 4));;
	}

	private int work(int[] a, int[] b, int n) {
		HashMap<Integer, Integer> map = new HashMap<>();
		int i=0;
		while(i<a.length) {
			map.putIfAbsent(a[i], 0);
			map.put(a[i], map.get(a[i])+1);
			map.putIfAbsent(b[i], 0);
			map.put(b[i], map.get(b[i])+1);
			i++;
		}
		int res = Integer.MIN_VALUE;
		i=0;
		while(i<a.length) {
			res = Math.max(res, map.get(a[i])+map.get(b[i])-1);
			i++;
		}
		return res;
	}
}
