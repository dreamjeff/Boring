package am;

import java.util.*;

import common.Go;

public class PrimeAir implements Go {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		List<List<Integer>> forwardRoutes = new ArrayList<List<Integer>>();
		List<List<Integer>> backwardRoutes = new ArrayList<List<Integer>>();
		List<Integer> route = new ArrayList<Integer>();
		route.add(4); route.add(1000); forwardRoutes.add(new ArrayList<Integer>(route)); route.clear();
		route.add(2); route.add(3000); forwardRoutes.add(new ArrayList<Integer>(route)); route.clear();
		route.add(3); route.add(4000); forwardRoutes.add(new ArrayList<Integer>(route)); route.clear();
		route.add(5); route.add(4000); forwardRoutes.add(new ArrayList<Integer>(route)); route.clear();
		route.add(1); route.add(5000); forwardRoutes.add(new ArrayList<Integer>(route)); route.clear();
		route.add(1); route.add(2000); backwardRoutes.add(new ArrayList<Integer>(route)); route.clear();
		route.add(3); route.add(5000); backwardRoutes.add(new ArrayList<Integer>(route)); route.clear();
		route.add(2); route.add(5000); backwardRoutes.add(new ArrayList<Integer>(route)); route.clear();
		route.add(4); route.add(6000); backwardRoutes.add(new ArrayList<Integer>(route)); route.clear();
		for(List<Integer> r : bestRoute(9000, forwardRoutes, backwardRoutes)) {
			System.out.println(r.get(0) + "," + r.get(1));
		}
	}

	/* Sort forward and backward so we can loop through the distant list in an order. After the sort, loop though the forward list and use 
	 * binary search to find the corresponding backward item in backward list. If there is shorter result, replace the existing result.
	 * Time complexity: forward sort : m*log(m) , backward sort : n*log(n) , for loop forward : m, binary search backward : log(n)
	 * Worse case have to loop through all the backward list for each forward item. So worse case : m*log(m) + n*log(n) + m * log(n) * n
	 * If each forward only have few item hit in backward list: TimeComplexty is m*log(m) + n*log(n) + m * log(n)
	 * Space complexity worse case is m*n for each item in forward and backward has the same length*/
	public List<List<Integer>> bestRoute(int maxTravelDist, List<List<Integer>> forwardRoutes, List<List<Integer>> backwardRoutes){
		forwardRoutes.sort(new Compare());
		backwardRoutes.sort(new Compare());
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		int maxDist = 0;
		for(int i = 0; i < forwardRoutes.size(); i++) {
			System.out.println("forward : " + i + " value : " + forwardRoutes.get(i).get(1));
			int index = binarySearch(maxTravelDist - forwardRoutes.get(i).get(1), backwardRoutes);
			for(int j = index; j < backwardRoutes.size(); j++) {
				int subres = forwardRoutes.get(i).get(1) + backwardRoutes.get(j).get(1);
				if( subres <= maxTravelDist) {
					if(subres > maxDist) {
						res.clear();
						List<Integer> newRes = new ArrayList<Integer>();
						newRes.add(forwardRoutes.get(i).get(0));
						newRes.add(backwardRoutes.get(j).get(0));
						res.add(newRes);
						maxDist = subres;
					}else if(subres == maxDist) {
						List<Integer> newRes = new ArrayList<Integer>();
						newRes.add(forwardRoutes.get(i).get(0));
						newRes.add(backwardRoutes.get(j).get(0));
						res.add(newRes);
					}else {
						break;
					}
				}
			}
		}
		return res;
	}
	
	private int binarySearch(int value, List<List<Integer>> backwardRoutes) {
		System.out.println("check:" + value);
		int i = 0, j = backwardRoutes.size()-1;
		while(i < j && j >= 0 && i < backwardRoutes.size()) {
			int mid = i + (j - i)/2;
			System.out.println(mid);
			if(backwardRoutes.get(mid).get(1) <= value) {
				j = mid-1;
			}else {
				i = mid+1;
			}
		}
		return j;
	}
	
	private class Compare implements Comparator<List<Integer>>{
		public int compare(List<Integer> l1, List<Integer> l2) {
			return l2.get(1) - l1.get(1);
		}
	}
}
