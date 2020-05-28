package am;

import common.Go;

public class Find_minimum_days_to_update_all_servers implements Go {
//	第二题：Find minimum days to update all servers
//	输入矩阵，1表示server是updated的，0表示server是out of date的，每一天，updated的sever可以把adjacent（上下左右）的out of date servers变成updated的server
//	输出int表示需要多少天整个矩阵的server都变成updated的server
//
//	举个例子：
//	输入
//	[[0,0,1],
//	[0,1,0],
//	[1,0,0]]
//	输出是2.
//
//	解释：
//	第一天后矩阵变成
//	[[0,1,1],
//	[1,1,1],
//	[1,1,0]]
//
//	第二天后矩阵变成全1（全1代表全部servers都updated了）
//	[[1,1,1],
//	[1,1,1],
//	[1,1,1]]
	@Override
	public void run() {
		// TODO Auto-generated method stub
		int[][] grid = new int[][] {{0,0,1},{0,1,0},{1,0,0}};
		System.out.println(findDays(grid));
	}
	
	private int findDays(int[][] grid) {
		int res = 0;
		boolean b = true;
		while(b) {
			b = false;
			for(int i=0; i<grid.length; i++) {
				for(int j=0; j<grid[0].length; j++) {
					if(grid[i][j]==1) change(grid, i, j);
					else b=true;
				}
			}
			res++;
		}
		return res-1;
	}

	private void change(int[][] grid, int i, int j) {
		if(i-1>=0) grid[i-1][j] = 1;
		if(j-1>=0) grid[i][j-1] = 1;
		if(i+1<grid.length) grid[i+1][j] = 1;
		if(j+1<grid[0].length) grid[i][j+1] = 1;
	}
}
