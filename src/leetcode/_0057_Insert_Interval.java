package leetcode;

import java.util.*;

public class _0057_Insert_Interval {
	//I try to merge directly, but too many edge case makes the code hard to read and understand.
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] res = new int[intervals.length+1][2];
        int j = 0, i = 0;
        while(i < intervals.length){
            if(newInterval!=null && intervals[i][0] > newInterval[0]){
                res[j++] = newInterval;
                newInterval = null;
            }
            res[j++] = intervals[i++];
        }
        if(newInterval!=null){
            res[j] = newInterval;
        }
        return merge(res);
    }
    
    private int[][] merge(int[][] intervals){
        List<List<Integer>> l = new LinkedList<>();
        List<Integer> cur = new LinkedList<>();
        cur.add(intervals[0][0]);
        cur.add(intervals[0][1]);
        for(int i = 0; i < intervals.length; i++){
            if(cur.get(1) < intervals[i][0]){
                l.add(cur);
                cur = new LinkedList<>();
                cur.add(intervals[i][0]);
                cur.add(intervals[i][1]);
            }else{
                cur.set(1, Math.max(cur.get(1), intervals[i][1]));
            }
        }
        l.add(cur);
        int[][] res = new int[l.size()][2];
        int i = 0;
        while(i < l.size()){
            res[i][0] = l.get(i).get(0);
            res[i][1] = l.get(i).get(1);
            i++;
        }
        return res;
    }
}
