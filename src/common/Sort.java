package common;

import java.util.*;

public class Sort implements Go {

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

	public void quickSort(int[] list, int start, int end) {
		if(start < end) {
			int piv = start + (end - start)/2;
			int l = start, r = end-1;
			while(l <= r) {
				while(l <= r && list[l] < list[piv]) l++;
				while(l <= r && list[r] >= list[piv]) r--;
				if(l < r) {
					swap(list, l, r);
					l++;
					r--;
				}
			}
			swap(list, l, end);
			quickSort(list, start, l-1);
			quickSort(list, l+1, end);
		}
	}
	
	private void swap(int[] list, int i, int j) {
		int tmp = list[i];
		list[i] = list[j];
		list[j] = tmp;
	}
	
	private void swap(List<Integer> list, int i , int j) {
		int tmp = list.get(i);
		list.set(i, list.get(j));
		list.set(j, tmp);
	}
}
