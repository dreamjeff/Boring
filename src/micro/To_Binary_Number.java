package micro;

import common.Go;

public class To_Binary_Number implements Go {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.print(work(123)[0] + "," + work(123)[1]);
	}

	private int[] work(int k) {
		int[] res = new int[2];
		while(k>0) {
			int temp = k%2;
			System.out.print(temp);
			if(temp==0) {
				res[0]++;
			}else {
				res[1]++;
			}
			k/=2;
		}
		System.out.println();
		return res;
	}
}
