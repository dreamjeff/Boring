package leetcode;

import common.Go;

public class _0275_H_Index_II implements Go {

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}
    public int hIndex(int[] citations) {
        for(int i=citations.length-1; i>=0; i--){
            if((citations.length-i-1)>=citations[i])
                return citations.length-i-1;
        }
        return citations.length;
    }
}
