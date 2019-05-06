package leetcode;

import common.*;

public class _0142_Linked_List_Cycle_II implements Go {

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast!=null){
            fast = fast.next;
            if(fast==null) return null;
            fast = fast.next;
            slow = slow.next;
            if(fast == slow) break;
        }
        if(fast==null) return null;
        ListNode res = head;
        while(res!=slow){
            res = res.next;
            slow = slow.next;
        }
        return res;
    }
}
