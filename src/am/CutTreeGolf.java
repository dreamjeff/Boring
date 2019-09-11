package am;

import common.Go;
import java.util.*;

public class CutTreeGolf implements Go {

//	��С���﹫˾���޳��أ���һ����ά������fields���������пӣ������ߡ� ����������Ҫ���������Ŀ�ķ������޺�һ��ĳ��ص���С������
//	public int flatFields (int numRows, int numColumns, List<List<Integer>> fields) {}. 留�申�论坛-丢�亩三分地
//	Ex1:
//
//	[1, 3, 0, 2].
//	[1, 1, 3, 1]
//	��ͼ�е�1����ƽ�أ������ߡ� 0����ӣ������ߡ� ����1�����ִ�����ľ����Ҫ�����������Ǵ����������ĸ��ǿ�ʼ��ѡһ����ʼ�ߣ��ȿ�����С����ľ�� ����2 < 3����ô�͵�����2��
//	��ͼ��������½ǿ�ʼ�����ξ����������ǣ� ��1�� 3�� -> (0, 3) -> (1, 3) -> (1, 2) -> (1, 1) -> (1, 0) ���Է��ص���С������5�� ��Ϊͨ�����·��������ƽ�ڶ������[1, 1, 3, 1]�� �����ߵ����½��յ㡣
//	Ex2:
//
//	[1, 0]
//	[3, 2]
//	��ͼ�е���С��������-1��Ϊ��û�а취�޺�һ�㣬 ��Ϊ�����Ͻ�1��ʼ�ߣ������ߵ�0�� Ҳ������3�� ��Ϊ��ȫ����3��2�󣬱�������2�����Ծ�û�����ˡ�
//
//	����˼·�ο���
//	BFS�����տ���˳��Ѱ������·�����ӣ���Ҫ�ҵ���������>1�ĵ㣩��Ȼ����˳����BFS�����԰����ŵ�TreeMap���棨�����HashMap�����鵽����Ŀ������ʼ����0.0Ҳ�������ĸ��ǣ�û��ϵ����ʼ�㶼����queue��ȥ��BFS���ɡ�����ע���յ���ܻ������һ������Ҳ����������·���߳����������һ�����������ĸ�������·�������ο����Ǵ��ĸ��㿪ʼ������߳����Ľⷨ��
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
