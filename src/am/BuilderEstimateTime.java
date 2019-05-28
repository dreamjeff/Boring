package am;

import java.util.*;

import common.Go;

public class BuilderEstimateTime implements Go{
	
	public void run()
	{
		List<Integer> list = new ArrayList<Integer>();
		list.add(8);
		list.add(4);
		list.add(6);
		list.add(12);
		System.out.println(MinimumTime(4, list));
		System.out.println("========================");
		list.clear();
		list.add(6);
		list.add(5);
		list.add(4);
		list.add(3);
		list.add(2);
		list.add(1);
		System.out.println(MinimumTime(4, list));
	}
	
	public int MinimumTime(int numberOfParts, List<Integer> parts) {
		if(numberOfParts <= 1) return 0;
		PriorityQueue<Integer> pq = new PriorityQueue<>(parts.size(), new Compare());
		for(Integer i : parts) {
			pq.offer(i);
		}
		int res = 0;
		while(!pq.isEmpty()) {
			Integer i = pq.poll();
			Integer j = pq.poll();
			res += i + j;
			System.out.println(res + " " + i + " " + j);
			if(pq.isEmpty()) {
				return res;
			}else {
				pq.offer(i + j);
			}
		}
		return res;
	}
	
	private class Compare implements Comparator<Integer>{
		@Override
		public int compare(Integer o1, Integer o2) {
			// TODO Auto-generated method stub
			return o1-o2;
		}
	}
}


