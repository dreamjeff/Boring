package leetcode;

import common.Go;
import java.util.*;

public class _0260_Single_Number_III implements Go {

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

    public int[] singleNumber(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int num : nums){
            if(set.contains(num)) set.remove(num);
            else set.add(num);
        }
        int[] res = new int[2];
        int i=0;
        Iterator<Integer> it = set.iterator();
        while(it.hasNext()){
            res[i++]=it.next();
        }
        return res;
    }
	
}
