/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;

    public Node() {}

    public Node(int _val,Node _prev,Node _next,Node _child) {
        val = _val;
        prev = _prev;
        next = _next;
        child = _child;
    }
};
*/
class Solution {
    
    public Node flattenNode(Node head) {
        Node curr = head, prev = null;
        
        while (curr != null) {
            Node child = curr.child;
            
            if (child != null) {
                Node end = flattenNode(child), tmp = curr.next;
                curr.child = null;

                curr.next = child;
                child.prev = curr;
                
                end.next = tmp;
                if (tmp != null) {
                    tmp.prev = end;
                }
                
                prev = end;
                curr = tmp;
            } else {
                prev = curr;
                curr = curr.next;
            }
        }
        
        return prev;
    }
    
    public Node flatten(Node head) {
        flattenNode(head);
        
        return head;
    }
}