package leetcode;

import common.*;

public class _0116_Populating_Next_Right_Pointers_in_Each_Node implements Go {

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

    public Node connect(Node root) {
        Node start = new Node();
        start.next = root;
        while(start.next!=null){
            Node cur = start.next;
            start.next = cur.left;
            if(cur.left==null) break;
            while(cur!=null){
                cur.left.next = cur.right;
                if(cur.next!=null){
                    cur.right.next = cur.next.left;
                }else{
                    cur.right.next = null;
                }
                cur = cur.next;
            }
        }
        return root;
    }
    
    public Node connect2(Node root) {
        connect(root, null);
        return root;
    }
    
    //root and right needs to be connect in this layer
    private void connect(Node root, Node right){
        if(root == null) return;
        root.next = right;
        connect(root.left, root.right);
        connect(root.right, right==null?null:right.left);
    }
}
