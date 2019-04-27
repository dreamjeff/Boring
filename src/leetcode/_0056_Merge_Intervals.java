package leetcode;

import common.Go;
import java.util.*;

public class _0056_Merge_Intervals implements Go {

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

    public int[][] merge(int[][] intervals) {
        List<List<Integer>> res = new LinkedList<>();
        if(intervals==null || intervals.length==0) return new int[0][0];
        sort(intervals, 0, intervals.length-1);
        List<Integer> cur = new LinkedList<>();
        cur.add(intervals[0][0]);
        cur.add(intervals[0][1]);
        for(int i = 0; i < intervals.length; i++){
            if(cur.get(1) >= intervals[i][0]){
                cur.set(1, Math.max(cur.get(1), intervals[i][1]));
            }else{
                res.add(cur);
                cur = new LinkedList<>();
                cur.add(intervals[i][0]);
                cur.add(intervals[i][1]);
            }
        }
        res.add(cur);
        int[][] r = new int[res.size()][2];
        for(int i = 0; i < res.size(); i++){
            r[i][0] = res.get(i).get(0);
            r[i][1] = res.get(i).get(1);
        }
        return r;
    }
    
    public void sort(int[][] intervals, int start, int end){
        if(start >= end) return;
        int l = start, r = end-1;
        int piv = intervals[end][0];
        while(l <= r){
            while(l <= r && intervals[l][0] < piv) l++;
            while(l <= r && intervals[r][0] >= piv) r--;
            if(l<r){
                swap(intervals, l, r);
                l++;
                r--;
            }
        }
        swap(intervals, l, end);
        sort(intervals, start, l-1);
        sort(intervals, l+1, end);
    }
    
    private void swap(int[][] intervals, int i, int j){
        int[] tmp = intervals[i];
        intervals[i] = intervals[j];
        intervals[j] = tmp;
    }
}
