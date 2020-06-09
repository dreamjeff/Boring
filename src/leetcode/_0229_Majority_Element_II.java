package leetcode;

import common.Go;
import java.util.*;

public class _0229_Majority_Element_II implements Go {

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}
	
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new LinkedList<>();
        int res1=0, res2=0, cnt1=0, cnt2=0, n=nums.length;
        for(int num : nums){
            if(num==res1) cnt1++;
            else if(num==res2) cnt2++;
            else if(cnt1==0) {res1=num; cnt1=1;}
            else if(cnt2==0) {res2=num; cnt2=1;}
            else {cnt1--; cnt2--;}
        }
        cnt1=0; cnt2=0;
        for(int num : nums){
            if(num==res1) cnt1++;
            else if(num==res2) cnt2++;
        }
        if(cnt1>(n/3)) res.add(res1);
        if(cnt2>(n/3)) res.add(res2);
        return res;
    }

}
