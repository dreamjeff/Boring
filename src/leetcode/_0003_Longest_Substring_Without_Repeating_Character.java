package leetcode;

import common.Go;
import java.util.*;

public class _0003_Longest_Substring_Without_Repeating_Character implements Go {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

    public int lengthOfLongestSubstring(String s) {
    	if(s==null || s.length()==0) return 0;
        HashSet<Character> set = new HashSet<>();
    	int l = 0, r = 0, res = Integer.MIN_VALUE;
        while(r < s.length()) {
        	char c = s.charAt(r);
        	if(set.contains(c)) {
        		while(l < r && set.contains(c)) {
        			set.remove(s.charAt(l));
        			l++;
        		}
        	}
    		set.add(c);
    		r++;
    		res = Math.max(r-l, res);
        }
        return res;
    }
}
