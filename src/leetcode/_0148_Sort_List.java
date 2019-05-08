package leetcode;

import common.*;

public class _0148_Sort_List implements Go {

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode fast = head, slow = head, last = head;
        while(fast!=null && fast.next!=null){
            last = slow;
            fast = fast.next.next;
            slow = slow.next;
        }
        last.next = null;
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);
        return merge(l1, l2);
    }
    
    private ListNode merge(ListNode l1, ListNode l2){
        ListNode start = new ListNode(0);
        ListNode cur = start;
        while(l1!=null&&l2!=null){
            if(l1.val > l2.val){
                cur.next = l2;
                l2 = l2.next;
            }else{
                cur.next = l1;
                l1 = l1.next;
            }
            cur = cur.next;
        }
        if(l1==null){
            cur.next = l2;
        }
        if(l2==null){
            cur.next = l1;
        }
        return start.next;
    }
}
