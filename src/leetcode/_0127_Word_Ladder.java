package leetcode;

import common.Go;
import java.util.*;

public class _0127_Word_Ladder implements Go {

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>();
        for(String s : wordList){
            set.add(s);
        }
        if(!set.contains(endWord)){
            return 0;
        }
        set.remove(beginWord);
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        int res = 0;
        while(!q.isEmpty()){
            res++;
            int size = q.size();
            while(size-->0){
                String s = q.poll();
                char[] c = s.toCharArray();
                for(int i = 0; i<s.length(); i++){
                    char cur = c[i];
                    for(char j = 'a'; j<='z'; j++){
                        c[i] = j;
                        String test = String.valueOf(c);
                        if(test.equals(endWord)) return res+1;
                        if(set.contains(test)){
                            q.add(test);
                            set.remove(test);
                        }
                    }
                    c[i] = cur;
                }
            }
        }
        return 0;
    }
}
