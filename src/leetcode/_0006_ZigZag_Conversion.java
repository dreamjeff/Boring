package leetcode;

import common.Go;

public class _0006_ZigZag_Conversion implements Go {

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

	//gap is the gap between the top characters, i+gap-2*i is the character between each top
    public String convert(String s, int numRows) {
        if(s==null || s.length()==0 || numRows<=0) return "";
        if(numRows==1) return s;
        StringBuilder sb = new StringBuilder();
        int gap = (numRows-1)*2;
        for(int i = 0; i < numRows; i++){
            int j = i;
            while(j < s.length()){
                sb.append(s.charAt(j));
                if(i!=0 && i!=numRows-1){
                    if(j+gap-2*i<s.length()){
                        sb.append(s.charAt(j+gap-2*i));
                    }
                }
                j+=gap;
            }
        }
        return sb.toString();
    }
}
