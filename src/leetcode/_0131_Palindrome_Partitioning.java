package leetcode;

import java.util.*;

public class _0131_Palindrome_Partitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new LinkedList<>();
        dfs(s, res, 0, new LinkedList<>(), new boolean[s.length()][s.length()]);
        return res;
    }
    
    private void dfs(String s, List<List<String>> res, int index, List<String> subres, boolean[][] ispalin){
        if(index==s.length()){
            res.add(new LinkedList<>(subres));
            return;
        }
        for(int i = index; i<s.length(); i++){
            if(ispalin[index][i] || isPalin(s, index, i)){
                ispalin[index][i] = true;
                subres.add(s.substring(index, i+1));
                dfs(s, res, i+1, subres, ispalin);
                subres.remove(subres.size()-1);
            }
        }
    }
    
    private boolean isPalin(String s, int i, int j){
        while(i<=j){
            if(s.charAt(i)!=s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}
