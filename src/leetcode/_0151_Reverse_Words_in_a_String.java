package leetcode;

import common.Go;

public class _0151_Reverse_Words_in_a_String implements Go {

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

    public String reverseWords(String s) {
        String[] sArray = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i=sArray.length-1; i>=0; i--){
            if(sArray[i].length()!=0){
                sb.append(sArray[i]);
                sb.append(" ");
            }
        }
        String res = sb.toString();
        return res.length()==0 ? res : res.substring(0, res.length()-1);
    }
}
