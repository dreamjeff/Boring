package leetcode;

import java.util.*;

public class _0146_LRU_Cache {
    HashMap<Integer, Node> map;
    Node start;
    Node end;
    int capacity;
    
    public _0146_LRU_Cache(int capacity) {
        map = new HashMap<>();
        start = new Node(0, 0, null, null);
        end = new Node(0, 0, start, null);
        start.next = end;
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            remove(map.get(key));
            moveToTop(map.get(key));
            return map.get(key).val;
        }else{
            return -1;
        }
    }
    
    public void put(int key, int value) {
        if(this.capacity==0){
            Node node;
            if(map.containsKey(key)){
                node = map.get(key);
            }else{
                node = end.pre;
            }
            remove(node);
            map.remove(node.key);
        }else{
            if(map.containsKey(key)){
                Node node = map.get(key);
                remove(node);
                map.remove(node.key);
            }else{
                this.capacity--;
            }
        }
        Node node = new Node(key, value, null, null);
        map.put(key, node);
        moveToTop(node);
    }
    
    private void moveToTop(Node node){
        node.next = start.next;
        start.next.pre = node;
        node.pre = start;
        start.next = node;
    }
    
    private void remove(Node node){
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }
    
    class Node{
        int key;
        int val;
        Node pre;
        Node next;
        public Node(int key, int val, Node pre, Node next){
            this.key = key;
            this.val = val;
            this.pre = pre;
            this.next = next;
        }
    }
}
