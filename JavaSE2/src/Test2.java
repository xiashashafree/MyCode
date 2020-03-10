class MyListedNode{
    int val;
    MyListedNode next;
    MyListedNode prev;
    public MyListedNode(int val){
        this.val=val;
        this.next=null;
        this.prev=null;

    }
}



class MyLinkedList {
    MyListedNode head;
    MyListedNode last;
    int size;

    /** Initialize your data structure here. */
    public MyLinkedList() {
        this.head=null;
        this.last=null;
        size=0;
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if(this.head == null){
            return -1;
        }
        MyListedNode cur=this.head;

        if(index<0||index>this.size){
            return -1;
        }
        cur=this.head;
        while(index>0){
            cur=cur.next;
        }
        return cur.val;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        MyListedNode node=new MyListedNode(val);
        if(this.head==null){
            this.head=node;
            this.size++;
            return;
        }
        node.next=this.head;
        this.head=node;
        this.size++;

    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        MyListedNode node=new MyListedNode(val);
        if(this.head==null){
            this.head=node;
            this.size++;
            return;
        }
        this.head.next=node;
        this.size++;
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if(index==0){
            this.addAtHead(val);
        }
        if(index==this.size){
            this.addAtTail(val);
        }
        MyListedNode cur=this.head;
        while(index-1>0){
            cur=cur.next;
            index--;
        }
        MyListedNode node=new MyListedNode(val);
        node.next=cur.next;
        cur.next=node;
        this.size++;
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if(index<0 ||index>size){
            return ;
        }
        if (this.head == null) {
            System.out.println("单链表为空");
            return;
        }
        //0、删除的节点是否是头结点
        if (index==0) {
            this.head = this.head.next;
            return;
        }
        MyListedNode del=this.head;
        //1、找到key的前驱  如果返回空
        while(index-1>=0){
            del=del.next;
            index--;
        }

        if (del == null) {
            return;
        }
        //2、删除节点

        del.next.prev=del.prev;
        del.prev.next=del.next;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */

public class Test2 {
}
