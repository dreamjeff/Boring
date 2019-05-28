package am;

import common.Go;
import java.util.*;

public class EachCharOnlyContainsInOneSubString implements Go {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		String s = "cdabaff";
		System.out.println("EachCharOnlyContainsInOneSubString : " + find(s));
	}

	public List<Integer> find(String s){
		List<Integer> res = new ArrayList<>();
		HashMap<Character, Integer> map = new HashMap<>();
		for(char c : s.toCharArray()) {
			if(map.containsKey(c)) {
				map.put(c, map.get(c)+1);
			}else {
				map.put(c, 1);
			}
		}
		int l = 0;
		HashMap<Character, Integer> subMap = new HashMap<>();
		for(int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if(subMap.containsKey(c)) {
				int remains = subMap.get(c);
				remains--;
				if(remains == 0) {
					subMap.remove(c);
					if(subMap.size() == 0) {
						res.add(i-l+1);
						l = i+1;
					}
				}else {
					subMap.put(c, remains);
				}
			}else {
				if(map.get(c) != 1) {
					subMap.put(c, map.get(c)-1);
				}else if(subMap.size() == 0) {
					res.add(1);
					l = i+1;
				}
			}
		}
		return res;
	}
}
