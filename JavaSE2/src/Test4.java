class Node{
    int data;
    Node next;
    public Node(int data){
        this.data=data;
        this.next=null;
    }
}
class LinkedList{
    Node head;
    int size;
   int getSize(){
       return size;
   }
   void addLast(int data){
       Node node=new Node(data);
       if(this.head==null){
           head=node;
           size++;
           return;
       }
       Node last=this.head;
       while(last.next!=null){
           last=last.next;
       }
       last.next=node;
       size++;
   }
   void addHead(int data){
       Node node=new Node(data);
       if(head==null){
           head=node;
           size++;
           return;
       }
       node.next=head;
       head=node;
       size++;

   }
   Node indexOf(int index){
       if(index<0||index>size-1){
           return null;
       }
       Node cur=this.head;
       while(index>0){

           cur=cur.next;
           index--;
       }
       return cur;
   }
   void addIndex(int index,int data){
       Node node=new Node(data);
       if(index>size||index<0){
           System.out.println("插入位置不合法");
           return;
       }
       if(index==0){
           addHead(data);
           return;
       }
       if(index==size){
           addLast(data);
           return;
       }
       Node pre=indexOf(index-1);
       node.next=pre.next;
       pre.next=node;
   }
   void delete(int index){
       if(index>size-1||index<0){
           System.out.println("没有这个结点");
           return;
       }
       Node node=indexOf(index-1);
       node.next=node.next.next;
   }
   void print(){
       Node cur=head;
       while(cur!=null){
           System.out.print(cur.data+" ");
           cur=cur.next;
       }
       System.out.println();
   }
}

public class Test4 {
    public static void main(String[] args) {
        LinkedList list=new LinkedList();

        list.addHead(1);
        list.addHead(2);
        list.addHead(3);

        list.addHead(4);
        list.addHead(5);
        list.addIndex(2,3);
        list.print();
        LinkedList list1=new LinkedList();
        list1.addLast(0);
        list1.addLast(6);
        list1.addLast(7);
        list1.addLast(8);
        list1.addLast(9);
        list1.print();
    }
}
