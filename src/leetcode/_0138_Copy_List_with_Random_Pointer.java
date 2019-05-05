package leetcode;

import common.Go;

public class _0138_Copy_List_with_Random_Pointer implements Go {

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}
    public Node copyRandomList(Node head) {
        Node cur = head;
        while(cur!=null){
            Node node = new Node(cur.val, cur.next, null);
            cur.next = node;
            cur = node.next;
        }
        cur = head;
        while(cur!=null){
            if(cur.random!=null) cur.next.random = cur.random.next;//random may be null!!
            cur = cur.next.next;
        }
        Node res = new Node();
        Node pre = res;
        cur = head;
        while(cur!=null){
            pre.next = cur.next;
            pre = pre.next;
            cur.next = cur.next.next;
            cur = cur.next;
        }
        return res.next;
    }
    
    class Node{
        public int val;
        public Node next;
        public Node random;

        public Node() {}

        public Node(int _val,Node _next,Node _random) {
            val = _val;
            next = _next;
            random = _random;
        }
    }
}

