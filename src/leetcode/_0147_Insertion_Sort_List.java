package leetcode;

import common.ListNode;

public class _0147_Insertion_Sort_List {
    public ListNode insertionSortList(ListNode head) {
        ListNode start = new ListNode(Integer.MIN_VALUE);
        while(head!=null){
            ListNode next = head.next;
            ListNode cur = start;
            //This adding part needs to be faster
            while(cur!=null){
                ListNode pre = cur;
                cur = cur.next;
                if(cur==null || head.val<cur.val){
                    pre.next = head;
                    head.next = cur;
                    break;
                }
            }
            head = next;
        }
        return start.next;
    }
}
