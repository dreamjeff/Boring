package leetcode;

import common.*;
import java.util.*;

public class _0061_Rotate_List implements Go {

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

    public ListNode rotateRight(ListNode head, int k) {
        int length = 0;
        ListNode run = head;
        ListNode end = head;
        while(run!=null){
            length++;
            end = run;
            run = run.next;
        }
        if(length==0 || k==0) return head;
        k = k%length;
        if(k==0) return head;
        length -=k;
        ListNode start = new ListNode(0);
        run = head;
        start.next = head;
        ListNode pre = start;
        while(length-->0){
            pre = run;
            run = run.next;
        }
        end.next = start.next;
        pre.next = null;
        return run;
    }
}
