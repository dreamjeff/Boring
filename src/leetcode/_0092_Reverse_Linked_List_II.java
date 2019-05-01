package leetcode;

import common.*;
import java.util.*;

public class _0092_Reverse_Linked_List_II implements Go {

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode start = new ListNode(0);
        start.next = head;
        ListNode pre = start;
        while(m>1){
            pre = pre.next;
            m--;
            n--;
        }
        ListNode end = pre.next;
        while(n>1){
            ListNode next = end.next;
            end.next = next.next;
            next.next = pre.next;
            pre.next = next;
            n--;
        }
        return start.next;
    }
}
