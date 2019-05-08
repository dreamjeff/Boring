package leetcode;

import java.util.*;

public class _0187_Repeated_DNA_Sequences {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new LinkedList<>();
        HashSet<String> resset = new HashSet<>();
        HashSet<String> set = new HashSet<>();
        for(int i=0; i<=s.length()-10; i++){
            String sub = s.substring(i, i+10);
            if(!set.add(sub)) resset.add(sub);
        }
        for(String ss : resset){
            res.add(ss);
        }
        return res;
    }
}
