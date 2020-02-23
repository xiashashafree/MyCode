
class Node{
    int val;
    Node next;
    public Node(int val){
        this.val=val;
        this.next=null;
    }

}
class LinkedList{
    Node head;
    public LinkedList(){
        this.head=null;
    }
	
	
    /**返回链表长度*/
    public int getLength(){
        Node cur=head;
        int len=0;
        while(cur!=null){
            len++;
            cur=cur.next;
        }
        return len;
    }

    /**头插法*/
    public void addFirst(int val){
        Node node=new Node(val);
        if(head==null){
            head=node;
            return;
        }
        head.next=node;
    }

    /**尾插法*/
    public void addLast(int val){
        Node node=new Node(val);
        if(this.head==null){
            head=node;
            return;
        }
        Node cur=head;
        while(cur.next!=null){
            cur=cur.next;
        }
        cur.next=node;

    }

    /**任意位置插入*/
    public void addIndex(int val,int index){
        if(index<0||index>this.getLength()){
            System.out.println("插入位置不合法");
            return;
        }

        if(index==0){
            addFirst(val);
            return;
        }
        if(index==this.getLength()){
            addLast(val);
            return;
        }
        Node cur=head;
        while(index>0){
            index--;
            cur=cur.next;
        }
        Node node=new Node(val);
        node.next=cur.next;
        cur.next=node;


    }

    /**输出数据*/
    public void display(){
        Node cur=head;
        while(cur!=null){

            System.out.print(cur.val+" ");
            cur=cur.next;
        }
        System.out.println();
    }



    public void display1(Node head){
        Node cur=head;
        while(cur!=null){

            System.out.print(cur.val+" ");
            cur=cur.next;
        }
        System.out.println();

    }




    /**返回倒数第k个结点  k从1开始*/
    public Node findKthToTail(int k){
        if(k<1||k>getLength()){
            return null;
        }
        Node fast=head;
        while(k-1>0){
            k--;
            fast=fast.next;
        }
        Node slow=head;
        while(slow.next!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next;
        }
        return slow;
    }

    /**返回中间结点*/
    public Node middleNode(){
        if(head==null){
            return  null;
        }
        Node fast=head;
        Node slow=head;
        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }

        return slow;
    }
/**be careful  ,you will achieve you goal*/
    /**翻转单链表*/
    public Node reverse(){
       Node pre=null;
       Node cur=head;
       Node newHead=null;
       while(cur!=null){
           Node curNext=cur.next;
           if(curNext==null){
               newHead=cur;
           }
           cur.next=pre;
           pre=cur;
           cur=curNext;
       }
       return newHead;

    }
    /**删除重复的连续值 */
    public void removeAllKey() {
        Node node = head;
        Node cur = head;
        while (cur != null) {

            if (cur.val != node.val) {
                node.next = cur;
                node = node.next;
                cur = cur.next;
            } else {
                cur = cur.next;
            }

        }

        if(node!=null){
            //2 1 3(node)  3  要将node.next置为空 否则删除不了最后的3
            node.next=null;
        }

    }

    public void removeDuplicateNodes() {
        Node node = head;
        Node cur = head;
        Node pre=cur;
        while (cur != null) {
            while (node != null) {
                if(node.val==cur.val){
                    pre.next=node.next;
                }
                pre=node;
                node=node.next;
            }
            pre=cur;
            cur = cur.next;
            if (cur != null) {
                node = cur.next;
            }
        }
    }


}

public class Review {
    public static void main(String[] args) {
        LinkedList L=new LinkedList();


        L.addLast(1);
        L.addLast(2);
        L.addLast(3);
        L.addLast(4);



        L.display();
//
//        //Node node=L.findKthToTail(6);
        Node node1=L.middleNode();
        System.out.println(node1.val);
//        Node newHead=L.reverse();
//        L.display1(newHead);
       // L.removeAllKey();
//        L.removeDuplicateNodes();
//        L.display();

    }



}
