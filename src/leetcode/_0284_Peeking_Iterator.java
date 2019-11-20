package leetcode;

import java.util.Iterator;

import common.Go;

public class _0284_Peeking_Iterator implements Go {

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

    Integer cur;
    Iterator<Integer> iterator;
    
	public _0284_Peeking_Iterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    this.iterator = iterator;
        if(this.iterator.hasNext())
            this.cur = this.iterator.next();
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        return cur;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	public Integer next() {
	    Integer res = cur;
        if(iterator.hasNext())
            cur = iterator.next();
        else
            cur = null;
        return res;
	}

	public boolean hasNext() {
	    return cur!=null;
	}
}
