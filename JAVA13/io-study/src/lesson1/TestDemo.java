package lesson1;
//
//import java.util.Comparator;
//import java.util.PriorityQueue;
//import java.util.Scanner;
//
//public class A {
//
//        public static void main(String[] args){
//            Scanner sc = new Scanner(System.in);
//            int size = sc.nextInt();
//            sc.nextLine();
//            PriorityQueue<String> q = new PriorityQueue<>(size,new Comparator<String>() {
//                @Override
//                public int compare(String o1, String o2) {
//                    if(o1.length()>o2.length())
//                        return 1;
//                    if(o1.length()<o2.length())
//                        return -1;
//
//                    return o1.compareTo(o2);
//                }
//            });
//            for(int i=0;i<size;i++){
//                String s = sc.nextLine();
//                q.offer(s);
//            }
//            while(q.size()>0){
//
//                System.out.println(q.poll());
//            }
//
//
//        }
//
//
//}
class A{
    private int count = 0;
    public A(int c){
        count =c;
    }
}
public class TestDemo{
    private int count;
    public static void main(String[] args) {
        TestDemo test=new TestDemo(88);
        System.out.println(test.count);
        A a = new A(0);
    }
    TestDemo(int a) {
        count=a;
    }
}
