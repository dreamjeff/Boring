package leetcode;

import common.Go;

public class _0005_Longest_Palindromic_Substring implements Go {

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

    public String longestPalindrome(String s) {
        String res = "";
        for(int i = 0; i < s.length(); i++){
            String subres1 = isPalindrome(s, i, i);
            String subres2 = isPalindrome(s, i, i+1);
            if(subres1.length() > res.length()) res = subres1;
            if(subres2.length() > res.length()) res = subres2;
        }
        return res;
    }
    
    private String isPalindrome(String s, int left, int right){
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        return s.substring(left+1, right);
    }
}
