package micro;

import common.Go;
import java.util.*;

public class Numbers_With_Equal_Digit_Sum implements Go {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		//new int[] {51, 71, 17, 42})
		//new int[] {42, 33, 60})
		//new int[] {51, 32, 43})
		System.out.print(work(new int[] {51, 32, 43}));
	}

	private int work(int[] a) {
		int res = -1;
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int i : a) {
			int key = sum(i);
			if(map.containsKey(key)) {
				int temp = map.get(key)+i;
				res = res>temp?res:temp;
				if(i>map.get(key)) {
					map.put(key, i);
				}
			}else {
				map.put(key, i);
			}
		}
		return res;
	}
	
	private int sum(int n) {
		int res = 0;
		while(n>0) {
			res+=n%10;
			n=n/10;
		}
		return res;
	}
}
