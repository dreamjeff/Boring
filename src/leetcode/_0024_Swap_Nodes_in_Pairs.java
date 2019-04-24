package leetcode;

import common.*;

public class _0024_Swap_Nodes_in_Pairs implements Go {

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

    public ListNode swapPairs(ListNode head) {
        ListNode start = new ListNode(0);
        start.next = head;
        ListNode pre = start;
        while(pre.next!=null && pre.next.next!=null){
            ListNode cur = pre.next;
            pre.next = cur.next;
            cur.next = pre.next.next;
            pre.next.next = cur;
            pre = cur;
        }
        return start.next;
    }
}
