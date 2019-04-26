package leetcode;

import common.Go;
import java.util.*;

public class _0049_Group_Anagrams implements Go {

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}
 
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for(String s : strs){
            char[] c = s.toCharArray();
            Arrays.sort(c);
            String key = new String(c);
            if(map.containsKey(key)){
                List<String> l = map.get(key);
                l.add(s);
                map.put(key, l);
            }else{
                List<String> l = new LinkedList<>();
                l.add(s);
                map.put(key, l);
            }
        }
        List<List<String>> res = new LinkedList<>();
        for(String s : map.keySet()){
            res.add(map.get(s));
        }
        return res;
    }
}
