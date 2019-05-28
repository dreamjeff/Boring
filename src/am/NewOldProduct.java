package am;

import java.util.*;

import common.Go;

public class NewOldProduct implements Go {
	//Given a list of new and old product id. sort those id. the 
	public void run() {
		List<String> products = new ArrayList<>();
		products.add("02k fox jump");
		products.add("k10 1a02 109 20");
		products.add("01h abc def");
		products.add("06z abc abc");
		products.add("01a fox jump");
		products.add("w10 124 324");
		for(String s : orderProduct2(products)) {
			System.out.println(s);
		}
	}
	
	private List<String> orderProduct(List<String> products){
		PriorityQueue<String> pq = new PriorityQueue<>(products.size(), new Compare());
		for(String s : products) {
			pq.offer(s);
		}
		List<String> res = new ArrayList<>();
		while(!pq.isEmpty()) {
			res.add(pq.poll());
		}
		return res;
	}
	
	private List<String> orderProduct2(List<String> products){
		List<String> numberList = new ArrayList<>();
		List<String> charList = new ArrayList<>();
		for(String s : products) {
			char c = s.charAt(s.indexOf(" ")+1);
			if(c >= '0' && c <= '9') {
				numberList.add(s);
			}else {
				charList.add(s);
			}
		}
		charList.sort(new NewCompare());
		numberList.sort(new NewCompare());
		for(String s : numberList) {
			charList.add(s);
		}
		return charList;
	}
	
	private class NewCompare implements Comparator<String>{
		public int compare(String s1, String s2) {
			int s1Index = s1.indexOf(" ");
			int s2Index = s2.indexOf(" ");
			String s1Head = s1.substring(0, s1Index);
			String s2Head = s2.substring(0, s2Index);
			String s1Tail = s1.substring(s1Index);
			String s2Tail = s2.substring(s2Index);
			if(s1Tail.equals(s2Tail)) {
				return s1Head.compareTo(s2Head);
			}else {
				return s1Tail.compareTo(s2Tail);
			}
		}
	}
	
	private class Compare implements Comparator<String>{
		public int compare(String s1, String s2) {
			int firstSpace = 4;
			while(firstSpace < s1.length() && firstSpace < s2.length()) {
				char c1 = s1.charAt(firstSpace);
				char c2 = s2.charAt(firstSpace);
				if(c1==c2) {
					firstSpace++;
					continue;
				}
				if(c1-'0' < 10 && c2-'0' < 10) return c1-c2;
				if(c1-'0' > 10 && c2-'0' > 10) return c1-c2;
				if(c1-'0' < 10) return 1;
				else return -1;
			}
			
			firstSpace = 0;
			while(firstSpace < 4) {
				if(s1.charAt(firstSpace)==s2.charAt(firstSpace)) {
					firstSpace++;
					continue;
				}
				return s1.charAt(firstSpace)-s2.charAt(firstSpace);
			}
			return 0;
		}
	}
}
