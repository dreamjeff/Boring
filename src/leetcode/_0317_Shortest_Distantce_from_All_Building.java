package leetcode;

import java.util.*;

public class _0317_Shortest_Distantce_from_All_Building {
    /**
     * @param grid: the 2D grid
     * @return: the shortest distance
     */
    public int shortestDistance(int[][] grid) {
        // write your code here
        int m = grid.length;
        int n = grid[0].length;
        int buildingNumber = 0;
        int[][] dist = new int[m][n];
        int[][] reach = new int[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]==1){
                    buildingNumber++;
                    Queue<int[]> q = new LinkedList<>();
                    boolean[][] get = new boolean[m][n];
                    q.add(new int[]{i, j});
                    get[i][j] = true;
                    int dis = 0;
                    while(!q.isEmpty()){
                        int size = q.size();
                        while(size-->0){
                            int[] cur = q.poll();
                            int x = cur[0], y = cur[1];
                            dist[x][y] += dis;
                            reach[x][y]++;
                            //find around avaliable space 
                            if(dis!=0 && grid[x][y]==1) continue;
                            if(x > 1 && !get[x-1][y] && grid[x-1][y]!=2){
                                get[x-1][y] = true;
                                q.add(new int[]{x-1, y});
                            }
                            if(x < m-1 && !get[x+1][y] && grid[x+1][y]!=2){
                                get[x+1][y] = true;
                                q.add(new int[]{x+1, y});
                            }
                            if(y > 1 && !get[x][y-1] && grid[x][y-1]!=2){
                                get[x][y-1] = true;
                                q.add(new int[]{x, y-1});
                            }
                            if(y < n-1 && !get[x][y+1] && grid[x][y+1]!=2){
                                get[x][y+1] = true;
                                q.add(new int[]{x, y+1});
                            }
                        }
                        dis++;
                    }
                }
            }
        }
        int res = Integer.MAX_VALUE;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]==0 && reach[i][j]==buildingNumber){
                    res = Math.min(dist[i][j], res);
                }
            }
        }
        return res;
    }
}
