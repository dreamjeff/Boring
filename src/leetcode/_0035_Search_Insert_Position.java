package leetcode;

public class _0035_Search_Insert_Position {
    public int searchInsert(int[] nums, int target) {
        int l = 0, r = nums.length-1;
        while(l<r){
            int mid = l + (r-l)/2;
            if(nums[mid] == target) return mid;
            if(nums[mid] < target){
                l = mid+1;
            }else{
                r = mid-1;
            }
        }
        return l;
    }
}
