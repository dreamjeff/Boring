package am;

import common.Go;
import java.util.*;

public class CutTreeGolf implements Go {

//	让小明帮公司球场修场地，给一个二维的链表fields，场地里有坑，不能走。 场地里有树要砍掉。最后目的返回是修好一层的场地的最小步数。
//	public int flatFields (int numRows, int numColumns, List<List<Integer>> fields) {}. 鐣欏鐢宠璁哄潧-涓€浜╀笁鍒嗗湴
//	Ex1:
//
//	[1, 3, 0, 2].
//	[1, 1, 3, 1]
//	上图中的1代表平地，可以走。 0代表坑，不能走。 大于1的数字代表树木，需要砍掉。规则是从上下左右四个角开始任选一个开始走，先砍数字小的树木。 比如2 < 3，那么就得先走2。
//	上图如果从右下角开始走依次经过的坐标是： （1， 3） -> (0, 3) -> (1, 3) -> (1, 2) -> (1, 1) -> (1, 0) 所以返回的最小步数是5， 因为通过这个路径可以修平第二层的球场[1, 1, 3, 1]， 并且走到左下角终点。
//	Ex2:
//
//	[1, 0]
//	[3, 2]
//	上图中的最小步数返回-1因为，没有办法修好一层， 因为从左上角1开始走，不能走到0， 也不能走3， 因为在全局中3比2大，必须先走2。所以就没法走了。
//
//	解题思路参考：
//	BFS来按照砍树顺序寻找最优路径。坑：先要找到所有树（>1的点），然后按照顺序做BFS。可以把树放到TreeMap里面（排序的HashMap）。抽到的题目可能起始点是0.0也可能是四个角，没关系把起始点都放入queue中去做BFS即可。再有注意终点可能会是最后一棵树，也可能是最优路径走出来（从最后一棵数到任意四个点的最短路径）。参考答案是从四个点开始走最后走出来的解法。
//	https://yidongzhang.gitbooks.io/-oa/golf-event.html
	@Override
	public void run() {
		// TODO Auto-generated method stub
		List<List<Integer>> trees = new ArrayList<>();
		List<Integer> l = new ArrayList<>();
		l.add(1); l.add(3); l.add(0); trees.add(new ArrayList<>(l)); l.clear();
		l.add(2); l.add(0); l.add(0); trees.add(new ArrayList<>(l)); l.clear();
		l.add(1); l.add(1); l.add(5); trees.add(new ArrayList<>(l)); l.clear();
		System.out.println("CutTreeGolf : " + find(trees));
	}

	public int find(List<List<Integer>> trees) {
		PriorityQueue<Integer> pq = new PriorityQueue<>(new Compare());
		for(List<Integer> l : trees) {
			for(Integer i : l) {
				if(i != 0 && i != 1) {
					pq.offer(i);
				}
			}
		}
		int res = 0;
		int curX = 0, curY = 0;
		while(!pq.isEmpty()) {
			int curHeight = pq.poll();
			System.out.println("Cut : " + curHeight);
			int[] subRes = bfs(curHeight, curX, curY, trees);
			if(subRes == null) return -1;
			res += subRes[2];
			curX = subRes[0];
			curY = subRes[1];
		}
		return res;
	}
	
	private int[] bfs(int height, int i, int j, List<List<Integer>> trees) {
		Queue<int[]> q = new LinkedList<>();
		boolean[][] visted = new boolean[trees.size()][trees.get(0).size()];
		q.add(new int[] {i,j});
		int depth = -1;
		while(!q.isEmpty()) {
			int size = q.size();
			depth++;
			while(size-- > 0){
				int[] cur = q.poll();
				int x = cur[0];
				int y = cur[1];
				System.out.println("Find : " + x + " , "+ y);
				if(trees.get(x).get(y) == height) {
					System.out.println("Found : " + height);
					trees.get(x).set(y, 1);
					return new int[] {x, y, depth};
				}
				visted[x][y] = true;
				for(int[] go : loop) {
					int nextX = x + go[0];
					int nextY = y + go[1];
					if(nextX >= 0 && nextX <trees.size() && nextY >= 0 && nextY < trees.get(0).size() 
							&& !visted[nextX][nextY] && trees.get(nextX).get(nextY) <= height 
							&& trees.get(nextX).get(nextY) != 0) {
						//System.out.println("Go Find : " + nextX + " , " + nextY);
						q.offer(new int[] {nextX, nextY});
					}
				}
			}
		}
		return null;
	}
	
	private int[][] loop = new int[][] {{-1,0},{1,0},{0,-1},{0,1}};
	
	private class Compare implements Comparator<Integer>{
		public int compare(Integer i, Integer j) {
			return i-j;
		}
	}
	
}
