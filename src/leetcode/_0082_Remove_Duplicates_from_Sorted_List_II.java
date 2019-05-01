package leetcode;

import common.*;

public class _0082_Remove_Duplicates_from_Sorted_List_II implements Go {

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next==null) return head;
        ListNode start = new ListNode(0);
        start.next = head;
        ListNode pre = start;
        while(pre.next!=null){
            ListNode cur = pre.next;
            if(cur==null) return start.next;
            ListNode next = cur.next;
            if(next==null) return start.next;
            if(next.val!=cur.val){
                pre = pre.next;
            }else{
                while(next!=null){
                    next = next.next;
                    if(next==null || next.val!=cur.val) break;
                }
                pre.next = next;
            }
        }
        return start.next;
    }
}
