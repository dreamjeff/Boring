package leetcode;

import java.util.*;

public class _0675_Cut_Off_Trees_For_Golf_Event {
	public int cutOffTree(List<List<Integer>> forest) {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Compare());
		for(List<Integer> list : forest) {
			for(Integer height : list) {
				if(height!=0 && height!=1) {
					pq.offer(height);
				}
			}
		}
		int res = 0;
		int m = forest.size(), n = forest.get(0).size();
		Position p = new Position(0, 0);
		while(!pq.isEmpty()) {
			int height = pq.poll();
			p = bfs(height, p, forest, m, n);
			if(p.length==-1) return -1;
			res += p.length;
		}
		return res;
	}
	
	public int cutOffTree2(List<List<Integer>> forest) {
		List<Integer> pq = new ArrayList<Integer>();
		for(List<Integer> list : forest) {
			for(Integer height : list) {
				if(height!=0 && height!=1) {
					pq.add(height);
				}
			}
		}
		Collections.sort(pq);
		int res = 0;
		int m = forest.size(), n = forest.get(0).size();
		Position p = new Position(0, 0);
		while(!pq.isEmpty()) {
			int height = pq.get(0);
			pq.remove(0);
			p = bfs(height, p, forest, m, n);
			if(p.length==-1) return -1;
			res += p.length;
		}
		return res;
	}
	
	private Position bfs(int height, Position p, List<List<Integer>> forest, int m, int n) {
		Queue<Position> q = new LinkedList<Position>();
		boolean[][] visited = new boolean[m][n];
		q.offer(p);
		visited[p.x][p.y] = true;
		int length = -1;
		while(!q.isEmpty()) {
			int size = q.size();
			length++;
			while(size-- > 0) {
				Position now = q.poll();
				System.out.println("Checking : " + now.x + "," + now.y);
				if(forest.get(now.x).get(now.y)==height) {
					p = now;
					p.length = length;
					return p;
				}
				for(int[] way : directions) {
					int nextX = now.x + way[0];
					int nextY = now.y + way[1];
					if(nextX >= 0 && nextX < m 
							&& nextY >= 0 && nextY < n
							&& !visited[nextX][nextY]
							&& forest.get(nextX).get(nextY)!=0) {
						q.offer(new Position(nextX, nextY));
						visited[nextX][nextY]=true;
					}
				}
			}
		}
		p.length = -1;
		return p;
	}

	private int[][] directions = new int[][] {{-1,0},{1,0},{0,-1},{0,1}};
}

class Compare implements Comparator<Integer>{
	public int compare(Integer i, Integer j) {
		return i-j;
	}
}

class Position{
	public int x, y, length;
	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public void add(Position p) {
		this.x += p.x;
		this.y += p.y;
	}
}

