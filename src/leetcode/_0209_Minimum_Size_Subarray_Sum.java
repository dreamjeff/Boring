package leetcode;

public class _0209_Minimum_Size_Subarray_Sum {
    public int minSubArrayLen(int s, int[] nums) {
        int l=0, r=0, min = Integer.MAX_VALUE,subres = 0;
        while(r<nums.length){
            while(r<nums.length && subres<s){
                subres+=nums[r++];
            }
            if(subres>=s){
                min = Math.min(min, r-l);
            }
            while(subres>=s && l<r){
                subres-=nums[l++];
                if(subres>=s){
                    min = Math.min(min, r-l);
                }
            }
        }
        if(min==Integer.MAX_VALUE) return 0;
        return min;
    }
}
