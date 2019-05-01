package leetcode;

import common.*;

public class _0086_Partition_List implements Go {

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

    public ListNode partition(ListNode head, int x) {
        ListNode l1 = new ListNode(0);
        ListNode p1 = l1;
        ListNode l2 = new ListNode(0);
        ListNode p2 = l2;
        while(head!=null){
            if(head.val < x){
                p1.next = head;
                p1 = p1.next;
            }else{
                p2.next = head;
                p2 = p2.next;
            }
            head = head.next;
        }
        p1.next = l2.next;
        p2.next = null;
        return l1.next;
    }
}
