package leetcode;

import common.Go;
import java.util.*;

public class _0318_Maximum_Product_of_Word_Lengths implements Go {

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}
    int res = 0;
    public int maxProduct(String[] words) {
        for(int i=0; i<words.length; i++){
            String str = words[i];
            HashSet set = findLetter(str);
            findMax(set, words, i);
        }
        return res;
    }
    
    private void findMax(HashSet set, String[] words, int index){
        for(int i=index+1; i<words.length; i++){
            char[] charArray = words[i].toCharArray();
            boolean contain = false;
            for(char c : charArray){
                if(set.contains(c)){
                    contain = true;
                    break;
                }
            }
            if(contain) continue;
            res = Math.max(res, words[index].length() * words[i].length());
        }
    }
    
    private HashSet findLetter(String str){
        char[] charArray = str.toCharArray();
        HashSet<Character> set = new HashSet<Character>();
        for(char c : charArray){
            set.add(c);
        }
        return set;
    }
}
