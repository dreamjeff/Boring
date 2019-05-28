package am;

import common.Go;
import java.util.*;

public class Maze implements Go {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		List<List<Integer>> maze = new ArrayList<>();
		List<Integer> l = new ArrayList<>();
		l.add(0); l.add(0); l.add(1); l.add(0); l.add(0); maze.add(new ArrayList<>(l)); l.clear();
		l.add(0); l.add(0); l.add(0); l.add(0); l.add(0); maze.add(new ArrayList<>(l)); l.clear();
		l.add(0); l.add(0); l.add(0); l.add(1); l.add(0); maze.add(new ArrayList<>(l)); l.clear();
		l.add(1); l.add(1); l.add(0); l.add(1); l.add(1); maze.add(new ArrayList<>(l)); l.clear();
		l.add(0); l.add(0); l.add(0); l.add(0); l.add(0); maze.add(new ArrayList<>(l)); l.clear();
		int[] start = new int[] {0,4};
		int[] des = new int[] {3,2};
		System.out.println("Maze : " + find(maze, start, des));
	}
	
	public int find(List<List<Integer>> maze, int[] start, int[] des) {
		int[][] dist = new int[maze.size()][maze.get(0).size()];
		for(int[] i : dist) {
			Arrays.fill(i, Integer.MAX_VALUE);
		}
		Queue<int[]> q = new LinkedList<>();
		q.offer(start);
		dist[start[0]][start[1]] = 0;
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			System.out.println("Find : " + cur[0] + " , " + cur[1]);
			for(int[] dir : loop) {
				int x = cur[0];
				int y = cur[1];
				int dis = dist[x][y];
				while(x >= 0 && x < maze.size() && y >= 0 && y < maze.get(0).size() && maze.get(x).get(y) == 0) {
					x += dir[0]; y += dir[1]; dis++;
				}
				x -= dir[0]; y -= dir[1]; dis--;
				if(dis < dist[x][y]) {
					dist[x][y] = dis;
					if(x != des[0] || y != des[1]) {
						System.out.println("Offer : " + x + " , " + y + " , " + dis);
						q.offer(new int[] {x,y});
					}
				}
			}
		}
		int res = dist[des[0]][des[1]];
		return res == Integer.MAX_VALUE ? -1 : res;
	}
	
	private int[][] loop = new int[][] {{1,0},{-1,0},{0,1},{0,-1}};
}
