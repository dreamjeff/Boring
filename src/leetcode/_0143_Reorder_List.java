package leetcode;

import common.*;

public class _0143_Reorder_List {
    public void reorderList(ListNode head) {
        if(head==null || head.next==null) return;
        ListNode fast = head;
        ListNode slow = head;
        ListNode pre = slow;
        while(fast!=null && fast.next!=null){
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode newList;
        if(fast==null){
            newList = slow;
            pre.next = null;
        }else{
            newList = slow.next;
            slow.next = null;
        }
        pre = null;
        while(newList.next!=null){
            ListNode next = newList.next;
            newList.next = pre;
            pre = newList;
            newList = next;
        }
        newList.next = pre;
        ListNode c1 = head;
        ListNode c2 = newList;
        while(c1!=null){
            if(c2 == null) break;
            ListNode n1 = c1.next;
            ListNode n2 = c2.next;
            c1.next = c2;
            c2.next = n1;
            c1 = n1;
            c2 = n2;
        }
    }
}
