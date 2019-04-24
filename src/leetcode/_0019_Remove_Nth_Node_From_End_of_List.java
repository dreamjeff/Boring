package leetcode;

import common.*;

public class _0019_Remove_Nth_Node_From_End_of_List implements Go {
	// watch out for the scenario [1] 1. We need to have one node before the head to handle the case that will remove the head.
	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode end = head;
        while(n-- > 0){
            end = end.next;
        }
        ListNode start = new ListNode(0);
        start.next = head;
        ListNode pre = start;
        while(end!=null){
            end = end.next;
            pre = pre.next;
        }
        pre.next = pre.next.next;
        return start.next;
    }
}
