package am;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

import common.Go;

import java.util.*;

public class GetMinimumCostToConstruct implements Go{
	
	public void run() {
		List<List<Integer>> roadsAvailable = new ArrayList<List<Integer>>();
		List<Integer> r1 = new ArrayList<Integer>();
		r1.add(1);
		r1.add(4);
		roadsAvailable.add(new ArrayList<Integer>(r1));
		r1.clear();
		r1.add(4);
		r1.add(5);
		roadsAvailable.add(new ArrayList<Integer>(r1));
		r1.clear();
		r1.add(2);
		r1.add(3);
		roadsAvailable.add(new ArrayList<Integer>(r1));
		r1.clear();
		List<List<Integer>> costNewRoadsConstruct = new ArrayList<List<Integer>>();
		r1.add(1); r1.add(2); r1.add(5);
		costNewRoadsConstruct.add(new ArrayList<Integer>(r1));
		r1.clear();
		r1.add(1); r1.add(3); r1.add(10);
		costNewRoadsConstruct.add(new ArrayList<Integer>(r1));
		r1.clear();
		r1.add(1); r1.add(6); r1.add(2);
		costNewRoadsConstruct.add(new ArrayList<Integer>(r1));
		r1.clear();
		r1.add(5); r1.add(6); r1.add(5);
		System.out.println(getMinimumCostToConstruct(6, 3, roadsAvailable, 4, costNewRoadsConstruct));
	}
	
	public int getMinimumCostToConstruct(int numTotalAvailableCities, int numTotalAvailableToads, List<List<Integer>> roadsAvailable, int numNewRoadsConstruct, List<List<Integer>> costNewRoadsConstruct) {
		UnionFind uf = new UnionFind(numTotalAvailableCities);
		for(List<Integer> road : roadsAvailable) {
			int city1 = road.get(0);
			int city2 = road.get(1);
			if(!uf.find(city1, city2)) {
				uf.union(city1,  city2);
			}
		}
		
		PriorityQueue<List<Integer>> pq = new PriorityQueue<>(numNewRoadsConstruct, new Compare());
		for(List<Integer> newRoad : costNewRoadsConstruct) {
			pq.offer(newRoad);
		}
		
		int res = 0;
		while(!pq.isEmpty()) {
			List<Integer> newRoad = pq.poll();
			if(uf.find(newRoad.get(0), newRoad.get(1))) continue;
			res += newRoad.get(2);
			uf.union(newRoad.get(0), newRoad.get(1));
			if(uf.count == 1) return res;
		}
		return 0;
	}
	
	private class Compare implements Comparator<List<Integer>>{

		@Override
		public int compare(List<Integer> o1, List<Integer> o2) {
			// TODO Auto-generated method stub
			return o1.get(2) - o2.get(2);
		}
		
	}
	
	private class UnionFind{
		private int[] cities;
		public int count;
		public UnionFind(int total) {
			this.count = total;
			cities = new int[total+1];
			for(int i = 1; i<=total; i++) {
				cities[i] = i;
			}
		}
		
		public void union(int i, int j) {
			int iID = root(i);
			int jID = root(j);
			if(iID != jID) {
				count--;
				for(int k = 1; k <cities.length; k++) {
					if(cities[k] == iID) {
						cities[k] = jID;
					}
				}
			}
		}
		
		public int root(int i) {
			return this.cities[i];
		}
		
		public boolean find(int i, int j) {
			return cities[i] == cities[j];
		}
	}
	
}




