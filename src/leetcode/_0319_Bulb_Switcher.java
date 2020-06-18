package leetcode;

import common.Go;

public class _0319_Bulb_Switcher implements Go {

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

    public int bulbSwitch(int n) {//它的因数有(1,36), (2,18), (3,12), (4,9), (6,6), 可以看到前四个括号里成对出现的因数各不相同，括号中前面的数改变了灯泡状态，后面的数又变回去了，等于灯泡的状态没有发生变化，只有最后那个(6,6)，在次数6的时候改变了一次状态，没有对应其它的状态能将其变回去了
        int res=1;
        while(res*res<=n) res++;
        return res-1;
    }
}
