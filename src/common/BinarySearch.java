package common;

public class BinarySearch implements Go {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		int[] list = new int[] {1,2,3,3,3,4,4,5,6,7,8,9};
		int val = 3;
		for(int i : list) {
			System.out.print(i + ",");
		}
		System.out.println();
		System.out.println("Find First Occur " + val + " : " + findFirstOccur(list, 3));
		System.out.println("Find Last Occur " + val + " : " + findLastOccur(list, 3));
		System.out.println("Find First Before " + val + " : " + findFirstBefore(list, 3));
		System.out.println("Find First After " + val + " : " + findFirstAfter(list, 3));
	}

	private int findFirstOccur(int[] list, int val) {
		int l = 0, r = list.length-1;
		while(l < r) {
			int mid = l+(r-l)/2;
			if(list[mid] == val) {
				r = mid;
			}else if(list[mid] < val) {
				l = mid+1;
			}else if(list[mid] > val){
				r = mid-1;
			}
		}
		return l;
	}
	
	private int findLastOccur(int[] list, int val) {
		int l = 0, r = list.length-1;
		while(l < r) {
			int mid = l+(r-l)/2+1;
			if(list[mid] == val) {
				l = mid;
			}else if(list[mid] < val) {
				l = mid+1;
			}else if(list[mid] > val) {
				r = mid-1;
			}
		}
		return l;
	}
	
	private int findFirstBefore(int[] list, int val) {
		int l = 0, r = list.length-1;
		while(l<r) {
			int mid = l+(r-1)/2+1;
			if(list[mid] >= val) {
				r = mid-1;
			}else {
				l = mid;
			}
		}
		return l;
	}
	
	private int findFirstAfter(int[] list, int val) {
		int l = 0, r = list.length-1;
		while(l<r) {
			int mid = l+(r-l)/2;
			if(list[mid] <= val) {
				l = mid+1;
			}else {
				r = mid;
			}
		}
		return l;
	}
}
