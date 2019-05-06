package leetcode;

import common.Go;
import java.util.*;

public class _0139_Word_Break implements Go {

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}
    public boolean wordBreak(String s, List<String> wordDict) {
        return dfs(s, 0, wordDict, new boolean[s.length()+1]);
    }
    
    private boolean dfs(String s, int index, List<String> wordDict, boolean[] visted){
        if(index==s.length()){
            return true;
        }
        for(String ss : wordDict){
            if(s.startsWith(ss, index) && !visted[index+ss.length()]){
                visted[index+ss.length()] = true;
                if(dfs(s, index+ss.length(), wordDict, visted)) return true;
            }
        }
        return false;
    }
}
