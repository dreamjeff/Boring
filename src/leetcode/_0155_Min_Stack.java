package leetcode;

import java.util.*;

public class _0155_Min_Stack {
    Stack<Integer> st;
    Stack<Integer> min;
    
    /** initialize your data structure here. */
    public _0155_Min_Stack() {
        st = new Stack<>();
        min = new Stack<>();
    }
    
    public void push(int x) {
        if(min.isEmpty()){
            min.push(x);
        }else{
            min.push(Math.min(x, min.peek()));
        }
        st.push(x);
    }
    
    public void pop() {
        st.pop();
        min.pop();
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        return min.peek();
    }
}
