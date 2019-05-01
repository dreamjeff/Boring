package leetcode;

import common.*;

public class _0083_Remove_Duplicates_from_Sorted_List implements Go {

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

    public ListNode deleteDuplicates(ListNode head) {
        if(head==null) return head;
        ListNode s = head, f = head;
        while(f!=null){
            if(f.val!=s.val){
                s.next = f;
                s = s.next;
            }
            f=f.next;
        }
        s.next = f;
        return head;
    }
}
