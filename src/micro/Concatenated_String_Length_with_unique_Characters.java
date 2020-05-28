package micro;
import java.util.*;

import common.Go;

public class Concatenated_String_Length_with_unique_Characters implements Go {

	String s = "";
	//Maximum Length of a Concatenated String with Unique Characters
	//https://leetcode.com/problems/maximum-length-of-a-concatenated-string-with-unique-characters/
	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

    int res = 0;
    public int maxLength(List<String> arr) {
        find(arr, 0, new HashSet<>(), 0);
        return res;
    }
    
    private void find(List<String> arr, int index, Set<Character> set, int subres){
        res = Math.max(res, subres);
        for(int k=index; k<arr.size(); k++){
            String s = arr.get(k);
            boolean jump = false;
            int i=0;
            for(;i<s.length();i++){
                if(set.contains(s.charAt(i))){
                    jump = true;
                    break;
                }
                set.add(s.charAt(i));
            }
            if(jump){
                for(int j=0; j<i; j++){
                    set.remove(s.charAt(j));
                }
                continue;
            }
            subres+=s.length();
            find(arr, k+1, set, subres);
            subres-=s.length();
            for(i=0; i<s.length();i++){
                set.remove(s.charAt(i));
            }
        }
    }
}
