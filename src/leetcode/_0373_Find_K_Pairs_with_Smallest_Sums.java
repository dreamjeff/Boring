package leetcode;

import common.Go;
import java.util.*;

public class _0373_Find_K_Pairs_with_Smallest_Sums implements Go {

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<List<Integer>> que = new PriorityQueue<>(new MyComparator());
        int n1 = nums1.length>k? k : nums1.length;
        int n2 = nums2.length>k? k : nums2.length;
        for(int i=0; i<n1; i++){
            for(int j=0; j<n2; j++){
                List<Integer> subres = new LinkedList<>();
                subres.add(nums1[i]);
                subres.add(nums2[j]);
                que.add(subres);
                if(que.size()>k) que.poll();
            }
        }
        List<List<Integer>> res = new LinkedList<>();
        while(!que.isEmpty()){
            res.add(que.poll());
        }
        return res;
    }
}

class MyComparator implements Comparator<List<Integer>>{
    public int compare(List<Integer> l1, List<Integer> l2){
        int sum1 = l1.get(0) + l1.get(1);
        int sum2 = l2.get(0) + l2.get(1);
        return sum2 - sum1;
    }
}