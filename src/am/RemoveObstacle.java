package am;

import common.Go;
import java.util.*;

public class RemoveObstacle implements Go {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		List<List<Integer>> lot = new ArrayList<List<Integer>>();
		List<Integer> level = new ArrayList<Integer>();
		level.add(1); level.add(0); level.add(9); lot.add(new ArrayList<Integer>(level)); level.clear(); 
		level.add(1); level.add(0); level.add(1); lot.add(new ArrayList<Integer>(level)); level.clear(); 
		level.add(1); level.add(1); level.add(1); lot.add(new ArrayList<Integer>(level)); level.clear(); 
		System.out.println("Remove One Obstacle : " + remove(lot));
	}

	
	public int remove(List<List<Integer>> lot) {
		boolean[][] visited = new boolean[lot.size()][lot.get(0).size()];
		Queue<int[]> q = new LinkedList<int[]>();
		q.offer(new int[] {0,0});
		int res = 0;
		while(!q.isEmpty()) {
			int size = q.size();
			for(int i = 0; i < size; i++) {
				int[] cur = q.poll();
				int x = cur[0];
				int y = cur[1];
				if(x < 0 || x >= lot.size() || y < 0 || y >= lot.get(0).size() || visited[x][y] || lot.get(x).get(y) == 0) 
					continue;
				visited[x][y] = true;
				if(lot.get(x).get(y) == 9)
					return res;
				q.offer(new int[] {x+1,y});
				q.offer(new int[] {x,y+1});
				q.offer(new int[] {x-1,y});
				q.offer(new int[] {x,y-1});
			}
			res++;
		}
		return -1;
	}
}
