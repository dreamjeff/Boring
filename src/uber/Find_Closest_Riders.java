package uber;

import java.util.*;

import common.Go;

public class Find_Closest_Riders implements Go{
//Give grid:
//	- - - - R
//	- B B R R
//	- B R B -
//	- R - - -
//	R is rider. can drive through
//	B is building. cannot drive through
//	- is road
//	
//	give a driver position and n # of rider to pick up.
//	Find the closest n riders( lowest number of total steps for driver to pick up n riders)
//	
//	eg: driver position (0,0)  n=3
//	return (1,3)(1,4)(0,4)
//	
//	edge case:
//	{'-','-','-','-','-'},
//	{'-','B','-','B','-'},
//	{'B','R','-','R','B'},
//	{'-','B','R','B','-'},
	@Override
	public void run() {
		// TODO Auto-generated method stub
		char[][] grid = new char[][] {
			{'-','-','-','-','-'},
			{'-','B','-','B','R'},
			{'B','R','-','R','B'},
			{'-','B','R','B','-'},};
		int[] driver = new int[] {0,0};
		List<int[]> riders = cloestRider(grid, 3, driver);
		for(int[] i : riders) {
			System.out.println(i[0] + "," + i[1]);
		}
	}
	
	private List<int[]> res;
	private int minStep = Integer.MAX_VALUE;
	
	private List<int[]> cloestRider(char[][] grid, int n, int[] driverPosition){
		int[][] hasVisited = new int[grid.length][grid[0].length];
		for(int i=0; i<hasVisited.length; i++) {
			for(int j=0; j<hasVisited[0].length; j++) {
				hasVisited[i][j] = 4;
			}
		}
		find(grid, 0, driverPosition, hasVisited, new LinkedList<>(), n);
		return res;
	}

	private void find(char[][] grid, int steps, int[] driverPosition, 
			int[][] hasVisited, List<int[]> subres, int n){
		if(subres.size()==n) {
			if(res==null || minStep>steps-1) {
				res = new LinkedList<>(subres);
				minStep = steps-1;
			}
			return;
		}
		// check boundary
		if(driverPosition[0]<0||driverPosition[0]>=grid.length
				|| driverPosition[1]<0 || driverPosition[1]>=grid[0].length) {
			return;
		}
		//check building
		if(grid[driverPosition[0]][driverPosition[1]]=='B') return;
		//each crossing can pass at most four times;
		if(hasVisited[driverPosition[0]][driverPosition[1]]==0) return;
		//add subres
		boolean isR = false;
		if(grid[driverPosition[0]][driverPosition[1]]=='R') {
			grid[driverPosition[0]][driverPosition[1]] = '-';
			subres.add(new int[] {driverPosition[0], driverPosition[1]});
			isR = true;
		}
		hasVisited[driverPosition[0]][driverPosition[1]]--;
		//go up
		driverPosition[0]++;
		find(grid, steps+1, driverPosition, hasVisited, subres, n);
		//go down
		driverPosition[0]-=2;
		find(grid, steps+1, driverPosition, hasVisited, subres, n);
		//go left
		driverPosition[0]++;
		driverPosition[1]--;
		find(grid, steps+1, driverPosition, hasVisited, subres, n);
		//go right
		driverPosition[1]+=2;
		find(grid, steps+1, driverPosition, hasVisited, subres, n);
		//recover position
		driverPosition[1]--;
		if(isR) {
			subres.remove(subres.size()-1);
			grid[driverPosition[0]][driverPosition[1]] = 'R';
		}
		hasVisited[driverPosition[0]][driverPosition[1]]++;
	}
}
