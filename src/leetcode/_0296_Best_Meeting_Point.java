package leetcode;

import java.util.*;

public class _0296_Best_Meeting_Point {
    /**
     * @param grid: a 2D grid
     * @return: the minimize travel distance
     */
    public int minTotalDistance(int[][] grid) {
        // Write your code here
        List<Integer> rows = new LinkedList<>();
        List<Integer> cols = new LinkedList<>();
        for(int i = 0; i<grid.length; i++){
            for(int j = 0; j<grid[0].length; j++){
                if(grid[i][j]==0) continue;
                rows.add(i);
                cols.add(j);
            }
        }
        return dis(rows) + dis(cols);
    }
    
    private int dis(List<Integer> list){
        int res = 0;
        list.sort(new Compare());
        while(list.size()>0){
            res += (list.get(list.size()-1) - list.get(0));
            list.remove(0);
            if(list.size()>0){
                list.remove(list.size()-1);
            }
        }
        return res;
    }
    
    private class Compare implements Comparator<Integer>{
        public int compare(Integer i, Integer j){
            return i-j;
        }
    }
}
