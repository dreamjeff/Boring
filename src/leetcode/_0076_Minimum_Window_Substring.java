package leetcode;

import common.Go;

public class _0076_Minimum_Window_Substring implements Go {

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

    public String minWindow(String s, String t) {
        int head = 0, l = 0, r = 0, min = Integer.MAX_VALUE, counter = 0;
        int[] map = new int[128];
        for(char c : t.toCharArray()){
            map[c]++;
            counter++;
        }
        while(r < s.length()){
            char c = s.charAt(r);
            if(map[c] > 0) counter--;
            map[c]--;
            r++;
            while(counter==0){
                if(r-l < min){
                    head = l;
                    min = r-l;
                }
                if(map[s.charAt(l)] == 0){//if current char at index l is 0, it means it was minus from > 0 which is one of the character in t
                    counter++;
                }
                map[s.charAt(l)]++;
                l++;
            }
        }
        return min == Integer.MAX_VALUE ? "" : s.substring(head, head+min);
    }
}
