package am;

import java.util.*;

import common.Go;

public class LunchChoice implements Go {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		List<List<String>> perfer = new ArrayList<List<String>>();
		List<List<String>> provide = new ArrayList<List<String>>();
		List<String> l = new ArrayList<>();
		l.add("ZhangSan"); l.add("Chinese"); perfer.add(new ArrayList<String>(l)); l.clear();
		l.add("LiSi"); l.add("American"); perfer.add(new ArrayList<String>(l)); l.clear();
		l.add("WangWu"); l.add("Janpanese"); perfer.add(new ArrayList<String>(l)); l.clear();
		l.add("XiaoMing"); l.add("*"); perfer.add(new ArrayList<String>(l)); l.clear();
		l.add("Chinese"); l.add("Rousi"); provide.add(new ArrayList<String>(l)); l.clear();
		l.add("Chinese"); l.add("Fish"); provide.add(new ArrayList<String>(l)); l.clear();
		l.add("American"); l.add("CheseBurger"); provide.add(new ArrayList<String>(l)); l.clear();
		for(List<String> ll : lunchList(perfer, provide)) {
			System.out.println(ll.get(0) + " : " + ll.get(1));
		}
	}

	public List<List<String>> lunchList(List<List<String>> perfer, List<List<String>> provide){
		HashMap<String, List<String>> map = new HashMap<>();
		for(List<String> p : provide) {
			if(map.containsKey(p.get(0))) {
				map.get(p.get(0)).add(p.get(1));
			}else {
				List<String> list = new ArrayList<>();
				list.add(p.get(1));
				map.put(p.get(0), list);
			}
		}
		List<List<String>> res = new ArrayList<List<String>>();
		for(List<String> people : perfer) {
			if(people.get(1) == "*") {
				for(List<String> list : map.values()) {
					for(String s : list) {
						List<String> each = new ArrayList<>();
						each.add(people.get(0));
						each.add(s);
						res.add(each);
					}
				}
			}else if(map.containsKey(people.get(1))) {
				for(String s : map.get(people.get(1))) {
					List<String> each = new ArrayList<>();
					each.add(people.get(0));
					each.add(s);
					res.add(each);
				}
			}
		}
		return res;
	}
	
}
