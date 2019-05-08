package leetcode;

public class _0152_Maximum_Product_Subarray {
    public int maxProduct(int[] nums) {
        //max save the preve max result, min save previous min result
        int max = nums[0], min = nums[0], res = nums[0];
        for(int i=1; i<nums.length; i++){
            if(nums[i]<0){//if a[i]<0, max and min will be reverse
                int tmp = max;
                max = min;
                min = tmp;
            }
            max = Math.max(nums[i], max*nums[i]);
            min = Math.min(nums[i], min*nums[i]);
            res = Math.max(max, res);
        }
        return res;
    }
}
