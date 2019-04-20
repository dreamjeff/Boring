package common;

import java.util.*;

public class MergeSort implements Go {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		int[] list = new int[] {9,1,8,2,7,3,6,4,5,0};
		mergeSort(list, 0, list.length-1);
		System.out.println("MergeSort:");
		for(int i : list) {
			System.out.print(i + ",");
		}
	}

	public void mergeSort(int[] list, int l, int r) {
		if(l<r) {
			int mid = l+(r-l)/2;
			mergeSort(list, l, mid);
			mergeSort(list, mid+1, r);
			merge(list, l, mid, r);
		}
	}
	
	private void merge(int[] list, int l, int mid, int r) {
		int i = l, j = mid+1;
		List<Integer> res = new LinkedList<>();
		while(i <= mid && j <= r) {
			res.add((list[i] < list[j] ? list[i++] : list[j++]));
		}
		while(i > mid && j <= r) {
			res.add(list[j++]);
		}
		while(j > r && i <= mid) {
			res.add(list[i++]);
		}
		for(int k = 0; k < res.size(); k++) {
			list[l+k] = res.get(k);
		}
	}
}
