package leetcode;

import java.util.*;

public class _0208_Implement_Trie_Prefix_Tree {
	class Trie {

	    boolean isword;
	    HashMap<Character, Trie> map;
	    /** Initialize your data structure here. */
	    public Trie() {
	        isword = false;
	        map = new HashMap<>();
	    }
	    
	    /** Inserts a word into the trie. */
	    public void insert(String word) {
	        if(word==null||word.length()==0){
	            this.isword = true;
	        }else{
	            if(!map.containsKey(word.charAt(0))){
	                map.put(word.charAt(0), new Trie());   
	            }
	            map.get(word.charAt(0)).insert(word.substring(1,word.length()));
	        }
	    }
	    
	    /** Returns if the word is in the trie. */
	    public boolean search(String word) {
	        if(word==null||word.length()==0){
	            return this.isword;
	        }else{
	            if(map.containsKey(word.charAt(0))){
	                return map.get(word.charAt(0)).search(word.substring(1,word.length()));
	            }else{
	                return false;
	            }
	        }
	    }
	    
	    /** Returns if there is any word in the trie that starts with the given prefix. */
	    public boolean startsWith(String prefix) {
	        if(prefix==null||prefix.length()==0){
	            return true;
	        }else{
	            if(map.containsKey(prefix.charAt(0))){
	                return map.get(prefix.charAt(0)).startsWith(prefix.substring(1,prefix.length()));
	            }else{
	                return false;
	            }
	        }
	    }
	}
}
