package am;

import java.util.*;

import common.Go;

public class SellBook implements Go {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		List<List<String>> books = new ArrayList<List<String>>();
		List<String> l = new ArrayList<String>();
		l.add("SanGuo"); l.add("ShuiHu"); books.add(new ArrayList<String>(l)); l.clear();
		l.add("ShuiHu"); l.add("HongLou"); books.add(new ArrayList<String>(l)); l.clear();
		l.add("HaLi"); l.add("JianShi"); books.add(new ArrayList<String>(l)); l.clear();
		for(String s : findBookGroup(books)) {
			System.out.println(s);
		}
	}

	public List<String> findBookGroup(List<List<String>> books){
		UnionFind uf = new UnionFind();
		for(List<String> l : books) {
			uf.union(l.get(0), l.get(1));
		}
		String groupRoot = uf.major;
		List<String> res = new ArrayList<>();
		for(String s : uf.books.keySet()) {
			System.out.print(s + " : " + uf.books.get(s) + " / ");
			if(uf.books.get(s) == groupRoot) {
				res.add(s);
			}
		}
		System.out.println();
		return res;
	}
	
	private class UnionFind{
		Map<String, String> books = new LinkedHashMap<String, String>();
		String major = "";
		int majorCount = 0;
		public void union(String book1, String book2) {
			if(!books.containsKey(book1)) {
				books.put(book1, book1);
			}
			if(!books.containsKey(book2)) {
				books.put(book2, book2);
			}
			String book1Root = root(book1);
			String book2Root = root(book2);
			int curCount = 0;
			for(String root : books.keySet()) {
				if(books.get(root) == book1Root) {
					books.put(root, book2Root);
					curCount++;
				}
				if(root == book2Root) {
					curCount++;
				}
			}
			if(curCount >= majorCount) {
				this.major = book2Root;
				this.majorCount = curCount;
			}
		}
		
		public String root(String book) {
			return books.get(book);
		}
		
		public boolean sameRoot(String book1, String book2) {
			return books.get(book1) == books.get(book2);
		}
	}
	
}
