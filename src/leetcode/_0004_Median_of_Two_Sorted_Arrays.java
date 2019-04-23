package leetcode;

import common.Go;

public class _0004_Median_of_Two_Sorted_Arrays implements Go{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

	//Thanks for : https://www.youtube.com/watch?v=LPFhl65R7ww&t=803s
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length) return findMedianSortedArrays(nums2, nums1);
        int left = 0, right = nums1.length;
        while(left <= right) {
        	int mid1 = left + (right-left)/2;
        	int mid2 = (nums1.length + nums2.length + 1)/2 - mid1;// +1 Works for both odd and even condition
        	int l1 = mid1 == 0 ? Integer.MIN_VALUE : nums1[mid1-1];
        	int r1 = mid1 == nums1.length ? Integer.MAX_VALUE : nums1[mid1];
        	int l2 = mid2 == 0 ? Integer.MIN_VALUE : nums2[mid2-1];
        	int r2 = mid2 == nums2.length ? Integer.MAX_VALUE : nums2[mid2];
        	if(l1<=r2 && l2<=r1) {
        		if((nums1.length+nums2.length)%2==0) {
        			return (Math.max(l1, l2) + Math.min(r1, r2))/2.0;
        		}else {
        			return Math.max(l1, l2);
        		}
        	}else if(l1 > r2) {
        		right = mid1-1;
        	}else if(l2 > r1) {
        		left = mid1+1;
        	}
        }
        return 0;
    }
}
