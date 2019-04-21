package leetcode;

import common.*;

public class _0002_Add_Two_Number implements Go {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(1);
		ListNode l3 = new ListNode(1);
		l3.next = l2;
		//l2.next = l1;
		ListNode l4 = new ListNode(1);
		ListNode l5 = new ListNode(1);
		ListNode l6 = new ListNode(1);
		l6.next = l5;
		l5.next = l4;
		ListNode res = addTwoNumber(l3, l6);
		while(res!=null) {
			System.out.print(res.val);
			res = res.next;
		}
	}

	public ListNode addTwoNumber(ListNode l1, ListNode l2) {
		ListNode res = new ListNode(0);
		ListNode cur = res;
		int remains = 0;
		while(l1!=null && l2!=null) {
			int subres = l1.val + l2.val + remains;
			remains = subres/10;
			ListNode newNode = new ListNode(subres%10);
			cur.next = newNode;
			cur = cur.next;
			l1 = l1.next;
			l2 = l2.next;
		}
		while(l1!=null) {
			int subres = l1.val + remains;
			remains = subres/10;
			ListNode newNode = new ListNode(subres%10);
			cur.next = newNode;
			cur = cur.next;
			l1 = l1.next;
		}
		while(l2!=null) {
			int subres = l2.val + remains;
			remains = subres/10;
			ListNode newNode = new ListNode(subres%10);
			cur.next = newNode;
			cur = cur.next;
			l2 = l2.next;
		}
		return res.next;
	}
}
