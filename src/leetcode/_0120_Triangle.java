package leetcode;

import java.util.*;

public class _0120_Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        List<Integer> res = new ArrayList<>();
        for(List<Integer> l : triangle){
            if(l.size()==1){
                res.add(l.get(0));
                continue;
            }
            List<Integer> newres = new ArrayList<>(l.size());
            for(int i = 0; i< l.size(); i++){
                if(i==0){
                    newres.add(res.get(0)+l.get(0));
                    continue;
                }
                if(i==l.size()-1){
                    newres.add(res.get(res.size()-1)+l.get(i));
                    continue;
                }
                newres.add(Math.min(res.get(i-1), res.get(i))+l.get(i));
            }
            res = newres;
        }
        int min = Integer.MAX_VALUE;
        for(Integer i : res){
            min = Math.min(min, i);
        }
        return min;
    }
}
