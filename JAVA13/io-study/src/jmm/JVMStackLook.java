package jmm;


//java虚拟机栈：
//1.和线程相关，不同县城中，即使运行同一个方法，也是出于不同内存
//2.和方法有关，即使是同一个线程，递归调用同一个方法，每次调用都会生成盖茨方法
public class JVMStackLook {
    public static void test(int[] array,int index){
        System.out.println(index);
        if(index<=2)
            return;
        test(array,index-1);
    }
    public static void test2(Node node){
        node.next=new Node("B");
        node = new Node("C");
    }
    public static void main(String[] args) {
        int[] array = {4,5,10,1,15};
        test(array,10);
        Node node = new Node("A");
        test2(node);
        System.out.println(node.name);
        System.out.println(node.next.name);
    }

    private static class Node{
        private Node next;
        private String name;

        public Node(String name){
            this.name = name;
        }
    }
}
