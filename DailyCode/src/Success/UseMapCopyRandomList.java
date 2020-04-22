package Success;

import java.util.HashMap;
import java.util.Map;

/***
 * 复杂链表的复制
 */

// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

class UseMapCopyRandomList {
    public Node copyRandomList(Node head) {
        if(null == head){
            return null;
        }
        Map<Node,Node> map = new HashMap();
        Node cur = head;
        while(cur != null){
            map.put(cur,new Node(cur.val));
            cur = cur.next;
        }

        for(Node node:map.keySet()){
            map.get(node).next = map.get(node.next);
            map.get(node).random = map.get(node.random);
        }
        return map.get(head);
    }
}
