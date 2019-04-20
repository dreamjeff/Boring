package common;

import java.util.*;

public class BucketSort implements Go {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		List<Integer> list = new ArrayList<>();
		Random r = new Random();
		for(int i = 0; i < 50; i++) {
			list.add(r.nextInt(999));
		}
		for(int i = 0; i < 50; i++) {
			list.add(r.nextInt(999)*-1);
		}
		bucketSort(list);
		for(Integer i : list) {
			System.out.print(i + " , ");
		}
	}

	public void bucketSort(List<Integer> list) {
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for(int i : list) {
			max = Math.max(max, i);
			min = Math.min(min, i);
		}
		
		int bucketNum = (max-min)/list.size() + 1;
		List<List<Integer>> bucket = new ArrayList<>(bucketNum);
		for(int i = 0; i < bucketNum; i++) {
			bucket.add(new ArrayList<>());
		}
		for(int i : list) {
			int bucketIndex = (i - min)/list.size();
			bucket.get(bucketIndex).add(i);
		}
		for(int i = 0; i < bucketNum; i++) {
			Collections.sort(bucket.get(i));
		}
		int k = 0;
		for(List<Integer> l : bucket){
			for(int i : l) {
				list.set(k++, i);
			}
		}
	}
}
