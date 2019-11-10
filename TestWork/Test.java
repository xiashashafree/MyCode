package TestWork;
class ListNode {
    public int data;
    public ListNode next;

    public ListNode(int data) {
        this.data = data;
        this.next = null;
    }

}//节点类
class MySingelList {//无头结点单项不循环
    public ListNode head;

    public MySingelList() {
        this.head = null;
    }
    public ListNode reverse(){
        ListNode cur=this.head;
        ListNode pre=null;
        ListNode newHead=null;
        while(cur!=null){
            ListNode curNext=cur.next;
            if(curNext==null){
                newHead=cur;
            }
            cur.next=pre;
            pre=cur;
            cur=curNext;
        }
        return newHead;
    }

  public ListNode search(int key){
        ListNode cur=this.head;
        while(cur!=null){
            if(cur.data==key)
                return cur;
            cur=cur.next;
        }
        return null;
}

  public void addFirst(int data){
        ListNode node=new ListNode(data);
        if(this.head==null){
            this.head=node;
        }
        node.next=this.head;
        this.head=node;
}

  public void addLast(int data) {
    ListNode node=new ListNode(data);
    if (this.head==null){
        this.head=node;
        return;
    }
    ListNode cur=this.head;
    while(cur.next!=null){
        cur=cur.next;
    }
    cur.next=node;

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
public ListNode searchIndex(int index){
        if(index<0||index>this.getLength()){
            return null;
        }
        ListNode cur=this.head;//包括了index=0的情况
        while(index>0){
            cur=cur.next;
            index--;
        }
        return cur;
}

  public void addIndex(int index,int data){
        if(index<0||index>this.getLength()){
            System.out.println("插入位置不合法");
            return;
        }
       if(index==0){
           this.addFirst(data);
           return;
       }
       ListNode cur=searchIndex(index-1);
       ListNode node=new ListNode(data);
       node.next=cur.next;
       cur.next=node;

  }
  public void remove(int key){
        ListNode cur=this.head;
        if(this.head.data==key){
            head=head.next;
            return;
        }
        while(cur.next!=null){
            if(cur.next.data==key){
                cur.next=cur.next.next;
                return;
            }
            cur=cur.next;
        }
    }
    public void removeAllKey(int key){
        ListNode cur=this.head;
        if(this.head.data==key){
            head=head.next;
            return;
        }
        while(cur.next!=null){
            if(cur.next.data==key){
                cur.next=cur.next.next;

            }else {
                cur = cur.next;
            }
        }
    }
    public boolean contains(int key){
        ListNode cur=this.head;
        while(cur!=null){
            if(cur.data==key){
                return true;
            }
            cur=cur.next;
        }
        return false;
    }
    public void clear(){
        this.head=null;
    }
   public void display(){
        ListNode cur=this.head;
        while(cur!=null){
            System.out.print(cur.data+" ");
            cur=cur.next;
        }
       System.out.println();
   }
   public ListNode reverseList(){
        ListNode cur=this.head;
        ListNode pre=null;
        ListNode newHead=null;
        while(cur!=null){
            ListNode curNext=cur.next;
            if(curNext==null){
                newHead=cur;
            }
            cur.next=pre;
            pre=cur;
            cur=curNext;
        }
        return newHead;

   }
   public void display2(ListNode head){
        ListNode cur=head;
        while(cur!=null){
            System.out.print(cur.data+" ");
            cur=cur.next;
        }
   }


   public ListNode middleNode(){
        if(this.head==null){
            return null;
        }
        ListNode fast=this.head;
        ListNode slow=this.head;
        while(fast!=null
                &&fast.next!=null//（附加）控制奇数情况下，防止空指针异常
                ){
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;

   }

   //返回倒数第k个结点
    //k从1计数
    public ListNode findKthToTail(int k){
        if(this.head==null){
            return null;
        }
        if(k<=0){
            System.out.println("无此结点");
            return null;
        }
        ListNode fast=this.head;
        ListNode slow=this.head;
        while(k>0){
            if(fast!=null){
            fast=fast.next;
            k--;
            }else{
                System.out.println("无此结点");
                return null;
            }
        }
        while(fast!=null){
            fast=fast.next;
            slow=slow.next;
        }
        return slow;
    }
    public ListNode partition(int x){
        ListNode cur=this.head;
        ListNode bs=null;
        ListNode be=null;
        ListNode as=null;
        ListNode ae=null;
        while(cur!=null){
            if(cur.data<x){
                if(bs==null){
                    bs=cur;
                    be=cur;
                    cur=cur.next;
                }else{
                    be.next=cur;
                    be=cur;
                    cur=cur.next;
                }
            }else{
                if(as==null){
                    as=cur;
                    ae=cur;
                    cur=cur.next;
                }else{
                    ae.next=cur;
                    ae=cur;
                    cur=cur.next;
                }
            }
        }
//    if(bs==null){
//            return as;
//    }
//    bs.next=as;
//        if(as!=null){
//          as.next=null;
//        }
//

        //before区间为空
        if(bs==null)
        {
            return as;
        }

        //after区间为空
        be.next=as;//as为null 或者   as只有一个结点 as.next=null

        if(as!=null){
            ae.next=null; // 1.尾结点的next为空   1 7 2 3 2 3   以7为x  as区间中只有7，要将数据位7的节点的next置为null
        }
        return bs;
    }
    public ListNode deleteDuplication() {
       ListNode cur=this.head;
       while(cur!=null&&cur.next!=null){
           if(cur.data==cur.next.data){
               cur=cur.next.next;
           }
           cur=cur.next;
       }

    }
}
  public class Test {
    public static ListNode mergeTwoList(ListNode head1,ListNode head2){
       return null;
    }

      public static void main(String[] args) {
          MySingelList list=new MySingelList();
          list.addLast(2);
          list.addLast(3);
          list.addLast(2);
          list.addLast(3);
          list.addLast(6);



          ListNode node=list.deleteDuplication();
          list.display2(node);

          //list.removeAllKey(2);
          //list.display();
          //ListNode head=list.reverse();
          //list.display2(head);

      }
}
