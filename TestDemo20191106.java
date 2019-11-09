/**
 * 2019-11-06
 * 双向链表
 *
 *
 */

/**
 * Java内存不需要管理
 * 垃圾回收器：当一个对象不被引用时
 *
 *JDK命令:javac java  javap -v   jps  jmap
 * 如何检查内存泄漏：1- jps
 *                  2-找到进程号
 *                 3-jmap -histo:live 进程号 > e:log.txt
 */
class ListNode{
    public int data;
    public ListNode prev;
    public ListNode next;
    public ListNode(int data){
        this.data=data;
        this.next=null;

    }
}
/**
 * 不带头结点的双向链表
 */
class DoubleList {
    public ListNode head;
    public ListNode last;//尾结点

    public void addFirst(int data){
        ListNode node=new ListNode(data);
        if(this.head==null){
            this.head=node;
            this.last=node;
        }else{
            node.next=this.head;
            head.prev=node;
            head=node;

        }
    }

    public void addLast(int data){
        ListNode node=new ListNode(data);
        if(this.last==null){
            last=node;
            head=node;
        }
        else{
            last.next=node;
            node.prev=last;
            last=node;
        }
    }
    public int getLength(){
        ListNode cur=this.head;
        int count=0;
        while(cur!=null){
            count++;
            cur=cur.next;
        }
        return count;
    }
    public void addIndex(int index,int data){
        ListNode node=new ListNode(data);
        if(index<0||index>this.getLength()){
            System.out.println("插入位置不合法");
            return ;
        }
        if(index==0) {
            node.next = head;
            head.prev = node;
            head = node;
            return ;
        }
        if(index==this.getLength()){
//            last.next=node;
//            node.prev=last;
//            last=node;
            this.addLast(data);
            return;
        }
        ListNode cur=this.head;
        while(index>0){
            cur=cur.next;
            index--;
        }
        node.prev=cur.prev;
        node.next=cur;
        cur.prev.next=node;
        cur.prev=node;

    }
    public boolean contains(int key){
        ListNode cur=this.head;
        while(cur!=null){
            if(cur.data==key)
                return true;
            cur=cur.next;
        }
        return false;
    }
    public int remove(int key){
        ListNode cur=this.head;
        if(key==head.data){
            head=head.next;
            head.prev=null;
            return key;
        }
        if(key==last.data){
           last=last.prev;
            last.next=null;
            return key;
        }
        while(cur!=null){
            if(cur.data==key){
                cur.prev.next=cur.next;
                cur.next.prev = cur.prev;
                return cur.data;
            }
            cur=cur.next;
        }
        return -1;

    }
    public void removeAllKey(int key){
        ListNode cur=this.head;
        if(key==head.data){
            head=head.next;
            head.prev=null;
        }
        if(key==last.data){
            last=last.prev;
            last.next=null;
        }
        while(cur!=null){
            if(cur.data==key){
                cur.prev.next=cur.next;
                cur.next.prev=cur.prev;
                cur=cur.next;
            }
            cur=cur.next;
        }

    }
    public void display(){
        if(this.head==null)
            return;
        ListNode cur=this.head;
        while(cur!=null){
            System.out.print(cur.data+" ");
            cur=cur.next;
        }
        System.out.println();
    }
    public void clear(){
        ListNode cur=this.head;
        while(cur!=null){
            cur=head.next;
            head.next=null;
            head.prev=null;
            head=cur;
        }
       last=null;
    }

}

public class TestDemo20191106 {

    public static void main(String[] args) {
        DoubleList list=new DoubleList();
        list.addLast(1);
        list.addLast(2);
        list.addLast(2);
        list.addLast(4);
        list.display();
        list.addIndex(2,5);
        list.display();
        int ret=list.remove(2);
        System.out.println(ret);
        list.display();
        list.clear();
        System.out.println("jskabk");
    }
}
