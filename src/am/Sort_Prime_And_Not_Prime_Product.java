package am;

import common.Go;
import java.util.*;

public class Sort_Prime_And_Not_Prime_Product implements Go {

	/*Prime product's second part is start with aplphabet, non prime product is start with number*/
	@Override
	public void run() {
		// TODO Auto-generated method stub
		List<String> products = new ArrayList<>();
		products.add("02k fox jump");
		products.add("k10 1a02 109 20");
		products.add("01h abc def");
		products.add("06z abc abc");
		products.add("01a fox jump");
		products.add("w10 124 324");
		for(String s : sort(products)) {
			System.out.println(s);
		}
	}

	public List<String> sort(List<String> list){
		PriorityQueue<String> primeQueue = new PriorityQueue<>(new Compare());
		PriorityQueue<String> notPrimeQueue = new PriorityQueue<>(new Compare());
		for(String s : list) {
			int index = s.indexOf(" ");
			if(s.charAt(index+1)-'0' <= 9) {
				notPrimeQueue.add(s);
			}else {
				primeQueue.add(s);
			}
		}
		List<String> res = new LinkedList<>();
		while(!primeQueue.isEmpty()) {
			res.add(primeQueue.poll());
		}
		while(!notPrimeQueue.isEmpty()) {
			res.add(notPrimeQueue.poll());
		}
		return res;
	}
	
	private class Compare implements Comparator<String>{
		public int compare(String s1, String s2) {
			int s1Index = s1.indexOf(" ");
			int s2Index = s2.indexOf(" ");
			String subS1 = s1.substring(s1Index);
			String subS2 = s2.substring(s2Index);
			int res = subS1.compareTo(subS2);
			if(res == 0) {
				return s1.substring(0, s1Index+1).compareTo(s2.substring(0, s2Index+1));
			}else {
				return res;
			}
		}
	}
}
