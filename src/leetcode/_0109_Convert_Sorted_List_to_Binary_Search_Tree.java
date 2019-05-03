package leetcode;

import common.*;
import java.util.*;

public class _0109_Convert_Sorted_List_to_Binary_Search_Tree implements Go {

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

    public TreeNode sortedListToBST(ListNode head) {
        return build(head, null);
    }
    
    private TreeNode build(ListNode head, ListNode end){
        if(head==end)return null;
        ListNode f = head, s = head;
        while(f!=end && f.next!=end){
            f = f.next.next;
            s = s.next;
        }
        TreeNode node = new TreeNode(s.val);
        node.left = build(head, s);
        node.right = build(s.next, end);
        return node;
    }
    
    public TreeNode sortedListToBST2(ListNode head) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int i = 0;
        while(head!=null){
            map.put(i++, head.val);
            head = head.next;
        }
        if(i==0) return null;
        return build(map, 0, i-1);
    }
    
    private TreeNode build2(HashMap<Integer, Integer> map, int l, int r){
        if(l>r) return null;
        int m = l+(r-l)/2;
        TreeNode node = new TreeNode(map.get(m));
        node.left = build(map, l, m-1);
        node.right = build(map, m+1, r);
        return node;
    }
}
