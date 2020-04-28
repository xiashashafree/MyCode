import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
        import java.util.Random;

class Card{
    private String suit;
    private int rank;
    public Card(String suit,int rank){
        this.suit=suit;
        this.rank=rank;
    }

    @Override
    public String toString() {
        String s=rank+"";
        switch(this.rank){
            case 11: s="J";
                break;
            case 12: s="Q";
                break;
            case 13: s="K";

        }
        return "Card{" +
                "suit='" + suit + '\'' +
                ", rank=" + s+
                '}';
    }
}
class CardDeam{
    // List<Card> cards=new ArrayList<Card>();
    String[] suits=new String[]{"♦","♠","♥","♣"};
    public List<Card> BuyCard(){
        List<Card> cards=new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            for (int j = 1; j <=13 ; j++) {
                cards.add(new Card(suits[i],j));
            }
        }
        return cards;
    }
    public void swap(List<Card> cards,int i,int j){
        Card tmp=cards.get(i);
        cards.set(i,cards.get(j));
        cards.set(j,tmp);
    }
    public List<Card> shuffle(List<Card> cards){
        for(int i=cards.size()-1;i>0;i--){
            Random rand=new Random(20191225);
            int j=rand.nextInt(i);
            this.swap(cards,i,j);
        }
        return cards;
    }




}
public class Test {
    public static void game(List<Card> cards) {
//        List<List<Card>> hand = new ArrayList<>();
//        for (int i = 0; i < 5; i++) {
//            hand.add(new ArrayList<Card>());
//            for (int j = 0; j < 3; j++) {
//                Card card = cards.remove(0);
//                hand.get(i).add(card);
//            }
//        }
//        for (int i = 0; i < hand.size(); i++) {
//            System.out.println(hand.get(i));
//        }
       int num=167773121;
       while(num!=0){
           System.out.print(num|0);
           num = num>>1;
       }
        System.out.println();

    }
    private static void numtoIP(int num){
        StringBuilder sb = new StringBuilder();

        while(num!=0){
            sb.append(num&1);
            num = num>>1;
        }
        int bit = 32-sb.length();
        for(int i=0;i<bit;i++){
            sb.append(0);
        }
        sb.reverse();
        for(int i=0;i<4;i++){

            System.out.print(Integer.parseInt(sb.substring((i*8),(i*8)+8)));
            if(i<3){
                System.out.print(".");
            }
        }
        System.out.println();
    }
    private static int toNum(int[] num,int index1,int index2){
        int bit = 0;
        int sum = 0;
        for(int i=index2;i>=index1;i--){
            if(num[i]!=0){
                sum = (int)(sum+(num[i]*(Math.pow(2,bit))));
            }

            bit++;
        }
        return sum;
    }

    private static void iptoNum(String IP){
        String[] str = IP.split("\\.");

        int[]ret = new int[32];
        int count = 0;
        for (String s:str ){
            System.out.println(s);
            int num = Integer.parseInt(s);
            for(int i=count*8+7;i>=count*8;i--){
                ret[i] = num&1;
                num>>=1;
            }
            count++;
        }

        int sum = 0;
        sum = toNum(ret,0,ret.length-1);
        System.out.println(sum);

    }

    public static void main(String[] args) {


//        int[] ret = new int[32];
//
//        int num = 167773121;
//        int index = 31;
//        while(num!=0){
//            ret[index--] = num&1;
//            num = num>>1;
//        }
//        int sum = 0;
//        for (int i = 0; i < ret.length; i++) {
//            System.out.print(ret[i]);
//        }
//        System.out.println();
//        for(int i=0;i<4;i++){
//            sum = toNum(ret,i*8,i*8+7);
//            System.out.print(sum);
//            if(i<3){
//                System.out.print(".");
//            }
//        }
//        System.out.println();
      iptoNum( "10.0.3.193");


    }
}
// class A<T> {
//
//    T value;
//
//
//
//    A(T value) {
//
//        this.value=value;
//
//    }
//
//
//
//    T get() {
//
//        return value;
//
//    }
//
//}
//class B{
//
//}
//public class Test{
//    public static int findJudge(int N, int[][] trust) {
//        List<Integer> list=new ArrayList<> ();
//        for(int i=0;i<trust.length;i++){
//            if(!list.contains(trust[i][0])){
//                list.add(trust[i][0]);
//            }
//        }
//
//        int k=1;
//        for(;k<=N;k++){
//            if(!list.contains(k)){
//                break;
//            }
//
//        }
////        int count=0;
//////        for(int i=0;i<trust.length;i++){
//////            if(trust[i][1]==k){
//////                count++;
//////            }
//////        }
//////        if(count==N-1){
//////            return k;
//////        }
//////        return -1;
//////
//////
//////    }
//////    public static void main(String[] args) {
//////   int [][] arr=new int[][]{ {1,2}
//////
//////        };
//////   int n=findJudge(2,arr);
//////        System.out.println(n);
//////    }
//////}
////import java.util.ArrayList;
////import java.util.List;
////
////// Employee info
////class Employee {
////    // It's the unique id of each node;
////    // unique id of this employee
////    public int id;
////    // the importance value of this employee
////    public int importance;
////    // the id of direct subordinates
////    public List<Integer> subordinates;
////};
////
////public class Test{
////    public static int getImportance(List<Employee> employees, int id) {
////      /*  int sum=0;
////        if(employees.subordinates!=null){
////            Employee e=em
////            getImportance(employees.subordinates,em)
////        }
////        Employee e=employees.get(0);
////        sum=e.importance;
////        for(int i=0;i<e.subordinates){
////            Employee dd=e.subordinates.get(i);
////
////            while(dd.subordinates!=null){
////                for()
////                Employee dd=dd.subordinates.get(0);
////                sum=sum+dd.importance;
////            }
////        }*/
////        int sum=0;
////
////        for(int i=0;i<employees.size();i++){
////            sum=sum+employees.get(i).importance;
////        }
////        return sum;
////
////
////    }
////
////    public static void main(String[] args) {
////       List<Integer> l=new ArrayList<Integer>();
////       l.add(0);
////       l.add(1);
////       l.add(2);
////      // ArrayList<Integer>  k=l.subList()
////               l.add(0,0);
////        System.out.println(l);
////        int size=l.size();
////        int num=l.get(l.size());
////        l=l.subList(1,size-1);
////        l.add(0,num);
////l.subList(0,2);
////
////    }
////
//
//class A{
//
//}
//class B{
//
//}
//class MyArrayList<E>{
//    int size;
//    int capacity;
//    E[] array;
//    public MyArrayList(int capacity){
//        array = (E[]) new Object[capacity];
//        size = 0;
//        this.capacity = capacity;
//    }
//
//    void add(E e)
//    {
//        // 检测容量
//        array[size++] = e;
//    }
//
//    int size()
//    {
//        return  size;
//    }
//
//    E get(int index)
//    {
//        // 检测index不能越界
//        return  (E)array[index];
//    }
//
//    boolean isEmpty()
//    {
//        return 0 == size;
//    }
//
//}
//
//public   class Test{
//    public static void main(String[] args) {
////        int i=new Integer(10);
////        Integer i1=Integer.valueOf(i);
////        i=i1.intValue();
//        int i=10;
//        Integer i1=i;
//        int j=i1;
//    }
//}
//

