package leetcode;

import java.util.*;

public class _0347_Top_K_Frequent_Elements {
    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            if(map.containsKey(nums[i])){
                Integer j = map.get(nums[i]);
                j++;
                map.put(nums[i], j);
            }else{
                map.put(nums[i], 1);
            }
        }
        PriorityQueue<int[]> p = new PriorityQueue<>(new Compare());
        for(Integer key : map.keySet()){
            int[] a = new int[]{key, map.get(key)};
            p.add(a);
            if(p.size()>k){
                p.poll();
            }
        }
        List<Integer> res = new LinkedList<>();
        while(p.size()>0){
            res.add(p.poll()[0]);
        }
        return res;
    }
    
    private class Compare implements Comparator<int[]>{
        public int compare(int[] a, int[] b){
            return a[1]-b[1];
        }
    }
}
