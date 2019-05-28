package am;

import common.Go;
import java.util.*;

public class HighestFrequenceWords implements Go {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		String s = "Jimmy has an apple, it is on the table";
		List<String> list = new ArrayList<>();
		list.add("an"); list.add("a"); list.add("is"); list.add("the"); 
		System.out.println("HighestFrequenceWords : ");
		for(String ss : find(s, list)) {
			System.out.println(ss);
		}
		
	}

	public List<String> find(String s, List<String> list) {
		List<String> res = new ArrayList<>();
		int longest = 0;
		HashSet<String> set = new HashSet<>(list);
		HashMap<String, Integer> map = new HashMap<>();
		for(String ss : s.split(" ")) {
			char last = ss.charAt(ss.length()-1);
			if( last == ',' || last == '.') {
				ss = ss.substring(0,ss.length()-1);
			}
			if(set.contains(ss)) continue;
			if(map.containsKey(ss)) {
				int count = map.get(ss)+1;
				map.put(ss, count);
				if(count > longest) {
					res.clear();
					res.add(ss);
					longest = count;
				}else if(count == longest) {
					res.add(ss);
				}
			}else {
				map.put(ss, 1);
				if(longest <= 1) {
					res.add(ss);
					longest = 1;
				}
			}
		}
		return res;
	}
}
