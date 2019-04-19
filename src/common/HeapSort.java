package common;

import java.util.*;

public class HeapSort implements Go {
	
	/*Minimum heap implementation*/
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		HeapSort hs = new HeapSort();
		hs.push(9);hs.push(8);hs.push(8);hs.push(6);hs.push(4);hs.push(1);hs.push(2);hs.push(3);
		while(!hs.isEmpty()) {
			System.out.print(hs.pop() + ",");
		}
	}

	private List<Integer> heap;
	
	public HeapSort() {
		heap = new ArrayList<Integer>();
	}
	
	public boolean isEmpty() {
		return this.heap.size() == 0 ? true : false;
	}
	
	public void push(int val) {
		heap.add(val);
		heapify(heap.size()-1);
	}
	
	public int pop() {
		int res = heap.get(0);
		heap.set(0, heap.get(heap.size()-1));
		heap.remove(heap.size()-1);
		sinkDown(0);
		return res;
	}
	
	public int peek() {
		return heap.get(0);
	}
	
	private int leftChild(int index) {
		int res = index*2+1;
		if(res < heap.size()) {
			return res;
		}
		return -1;
	}
	
	private int rightChild(int index) {
		int res = index*2+2;
		if(res < heap.size()) {
			return res;
		}
		return -1;
	}
	
	private int parent(int index) {
		return (index-1)/2;
	}
	
	private void sinkDown(int index) {
		if(index < heap.size()) {
			int leftChild = leftChild(index);
			int rightChild = rightChild(index);
			int minIndex = index;
			if(leftChild > 0) {
				minIndex = heap.get(index) > heap.get(leftChild) ? leftChild : index;
			}
			if(rightChild > 0) {
				minIndex = heap.get(minIndex) > heap.get(rightChild) ? rightChild : minIndex;
			}
			if(minIndex != index) {
				swap(index, minIndex);
				sinkDown(minIndex);
			}
		}
	}
	
	private void heapify(int index) {
		if(index > 0) {
			int parent = parent(index);
			if(heap.get(index) < heap.get(parent)) {
				swap(index, parent);
				heapify(parent);
			}
		}
	}
	
	private void swap(int i, int j) {
		int tmp = heap.get(i);
		heap.set(i, heap.get(j));
		heap.set(j, tmp);
	}
}
