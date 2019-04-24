package leetcode;

import common.*;

public class _0025_Reverse_Nodes_in_k_Group implements Go {

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode start = new ListNode(0);
        start.next = head;
        ListNode pre = start;
        ListNode end = pre.next;
        int num = 0;
        while(end!=null){
            end = end.next;
            num++;
        }
        while(num>=k){
            end = pre.next;
            for(int i = 1; i < k; i++){
                ListNode cur = pre.next;
                pre.next = end.next;
                end.next = pre.next.next;
                pre.next.next = cur;
            }
            pre = end;
            num -= k;
        }
        return start.next;
    }
}
