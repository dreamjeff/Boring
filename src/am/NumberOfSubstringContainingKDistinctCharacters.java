package am;

import common.Go;
import java.util.*;

public class NumberOfSubstringContainingKDistinctCharacters implements Go {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		String s = "abcdcf";
		int k = 3;
		System.out.println("NumberOfSubstringContainingKDistinctCharacters : " + find(s, k));
	}

	
	public int find(String s, int k) {
		HashMap<Character,Integer> set = new HashMap<Character,Integer>();
		int l = 0;
		int res = 0;
		for(int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if(set.containsKey(c)) {
				set.put(c, set.get(c)+1);
			}else {
				set.put(c, 1);
			}
			while(set.size() > k){
				char remove = s.charAt(l++);
				int remains = set.get(remove);
				if(--remains > 0) {
					set.put(remove, remains);
				}else {
					set.remove(remove);
				}
			}
			if(set.size() == k) {
				res++;
				System.out.println(s.substring(l, i+1));
			}
		}
		while(set.size() == k) {
			char remove = s.charAt(l++);
			int remains = set.get(remove);
			if(--remains > 0) {
				set.put(remove, remains);
				res++;
				System.out.println(s.substring(l, s.length()));
			}else {
				set.remove(remove);
			}
		}
		return res;
	}
}
