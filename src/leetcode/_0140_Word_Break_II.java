package leetcode;

import common.Go;
import java.util.*;

public class _0140_Word_Break_II implements Go {

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> res = dfs(s, 0, wordDict, new HashMap<>());
        for(int i=0; i<res.size(); i++){
            String ss = res.get(i);
            ss = ss.substring(0,ss.length()-1);
            res.set(i, ss);
        }
        return res;
    }
    
    private List<String> dfs(String s, int offset, List<String> wordDict, HashMap<Integer, List<String>> map){
        if(offset==s.length()){
            List<String> res = new LinkedList<>();
            res.add("");
            map.put(offset, res);
            return res;
        }
        List<String> res = new LinkedList<>();
        for(String word : wordDict){
            if(s.startsWith(word, offset)){
                if(map.containsKey(offset+word.length())){
                    for(String ss : map.get(offset+word.length())){
                        res.add(word + " " + ss);
                    }
                }else{
                    for(String ss : dfs(s, offset+word.length(), wordDict, map)){
                        res.add(word + " " + ss);
                    }
                }
            }
        }
        map.put(offset, res);
        return res;
    }
}
