package leetcode;

import common.Go;

public class _0211_Add_and_Search_Word_Data_structure_design implements Go {

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

	class WordDictionary {

	    WordDictionary[] map;
	    boolean isword;
	    
	    /** Initialize your data structure here. */
	    public WordDictionary() {
	        map = new WordDictionary[26];
	        isword = false;
	    }
	    
	    /** Adds a word into the data structure. */
	    public void addWord(String word) {
	        if(word==null||word.length()==0){
	            isword = true;
	            return;
	        }
	        int c = word.charAt(0)-'a';
	        if(map[c]==null){
	            map[c]=new WordDictionary();
	        }
	        map[c].addWord(word.substring(1, word.length()));
	    }
	    
	    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
	    public boolean search(String word) {
	        if(word==null||word.length()==0){
	            return isword?true:false;
	        }
	        int c = word.charAt(0)-'a';
	        if(word.charAt(0)=='.'){
	            for(WordDictionary w : map){
	                if(w!=null && w.search(word.substring(1,word.length()))){
	                    return true;
	                }
	            }
	            return false;
	        }else if(map[c]!=null){
	            return map[c].search(word.substring(1,word.length()));
	        }else{
	            return false;
	        }
	    }
	}
}
