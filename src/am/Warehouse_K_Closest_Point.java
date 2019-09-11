package am;

import java.util.*;
import common.Go;

public class Warehouse_K_Closest_Point implements Go{

//	亚麻建了个新warehouse，从多个地点运东西过去，选择最近的k个点。就是k closest points，用priorityqueue。
//
//	这题类似如下题目。
//	Given somepointsand a pointoriginin two dimensional space, findkpoints out of the some points which are nearest toorigin.
//	Return these points sorted by distance, if they are same with distance, sorted by x-axis, otherwise sorted by y-axis.
	
	class Point{
		int x, y;
		Point(int a, int b){
			this.x = a;
			this.y = b;
		}
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	
	private Point[] kClosest(Point[] points, Point origin, int k) {
		Compare com = new Compare(origin);
		PriorityQueue<Point> pq = new PriorityQueue<Point>(k,com);
		for(Point p : points) {
			pq.offer(p);
			if(pq.size()>k) {
				pq.poll();
			}
		}
		k = pq.size();//if total points is less than k
		Point[] res = new Point[k];
		while(!pq.isEmpty()) {
			res[--k] = pq.poll();
		}
		return res;
	}

	class Compare implements Comparator<Point>{

		private Point origin;
		
		public Compare(Point origin) {
			this.origin = origin;
		}
		
		@Override
		public int compare(Point o1, Point o2) {
			// TODO Auto-generated method stub
			int diff = getDistance(o1, this.origin) - getDistance(o1, this.origin);
			if(diff==0) diff = o1.x - o2.x;
			if(diff==0) diff = o1.y - o2.y;
			return diff;
		}
		
	}
	
	private int getDistance(Point a, Point origin) {
		return (a.x - origin.x)*(a.x - origin.x) + (a.y - origin.y)*(a.y - origin.y);
	}
	
}
