package leetcode;

import common.*;

public class _0117_Populating_Next_Right_Pointers_in_Each_Node_II implements Go {

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

    public Node connect(Node root) {
        Node start = new Node();
        start.next = root;
        while(start.next!=null){
            Node cur = start.next;
            Node pre = start;
            pre.next = null;//remember clear the start pointer at the beginning, otherwise the last line will loop for ever.
            while(cur!=null){
                if(cur.left!=null){
                    pre.next = cur.left;
                    pre = pre.next;
                }
                if(cur.right!=null){
                    pre.next = cur.right;
                    pre = pre.next;
                }
                cur = cur.next;
            }
        }
        return root;
    }
}
