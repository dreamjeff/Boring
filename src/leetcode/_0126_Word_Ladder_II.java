package leetcode;

import common.Go;
import java.util.*;

public class _0126_Word_Ladder_II implements Go {

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new LinkedList<>();
        HashSet<String> set = new HashSet<>();
        for(String s : wordList){
            set.add(s);
        }
        if(!set.contains(endWord)) return res;
        set.remove(beginWord);
        HashMap<String, List<List<String>>> map = new HashMap<>();
        List<List<String>> f1 = new LinkedList<>();
        List<String> f2 = new LinkedList<>();
        f2.add(beginWord);
        f1.add(f2);
        map.put(beginWord, f1);
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        while(!q.isEmpty()){
            int size = q.size();
            List<String> remove = new LinkedList<>();
            while(size-->0){
                String cur = q.poll();
                char[] c = cur.toCharArray();
                for(int i=0; i<cur.length(); i++){
                    char hold = c[i];
                    for(char j='a'; j<='z'; j++){
                        c[i] = j;
                        String test = String.valueOf(c);
                        if(set.contains(test)){
                            remove.add(test);
                            if(!map.containsKey(test)) map.put(test, new LinkedList<>());
                            List<List<String>> mapcur = map.get(test);
                            for(List<String> subres : map.get(cur)){
                                subres.add(test);
                                if(test.equals(endWord)){
                                    res.add(new LinkedList<>(subres));
                                }else{
                                    mapcur.add(new LinkedList<>(subres));
                                }
                                subres.remove(subres.size()-1);
                            }
                        }
                    }
                    c[i] = hold;
                }
                map.remove(cur);
            }
            for(String s : remove){
                if(set.remove(s)) q.add(s);
            }
            if(res.size()>0) break;
        }
        return res;
    }
}
