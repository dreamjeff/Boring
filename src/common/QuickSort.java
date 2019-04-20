package common;

public class QuickSort implements Go {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		int[] list = new int[] {5,3,7,8,9,5,2,6,7,8,9,5,6,1,2,3,4};
		quickSort(list, 0, list.length-1);
		for(int i : list) {
			System.out.print(i + ",");
		}
	}

	public void quickSort(int[] list, int start, int end) {
		if(start < end) {
			int l = start, r = end-1;
			while(l <= r) {
				while(l <= r && list[l] < list[end]) l++;
				while(l <= r && list[r] >= list[end]) r--;
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
}
