//class Person{
//
//}
//class Book{
//
//}
////class MyArrayList<E>{
////    Object[] arr;
////    int size;
////    int capacity;
////    public MyArrayList(int capacity){
////        this.arr=new Object[]{};
////        this.size=0;
////        this.capacity=capacity;
////
////    }
////    void add(E o){
////        this.arr[size]=o;
////        size++;
////    }
////    Object get(int index){
////        return this.arr[index];
////    }
////    int getSize(){
////        return size;
////    }
////}
//
//class MyArrayList<E>
//{
//    public MyArrayList(int capacity){
//        array = (E[])new Object[capacity];
//
//        this.capacity = capacity;
//    }
//
//    public void add(E e)
//    {
//        // 检测容量
//        array[size++] = e;
//    }
//
//    public int size()
//    {
//        return  size;
//    }
//
//    E get(int index)
//    {
//        // 检测index不能越界
//        return  array[index];
//    }
//
//    boolean isEmpty()
//    {
//        return 0 == size;
//    }
//
//    E[] array;
//    int capacity;  // 空间的总大小
//    int size;      // 空间中存储有效元素的个数
//}
//
//public class Demo {
//    public static void main(String[] args) {
////        MyArrayList<Book> aa=new MyArrayList<Book>(10);
//////        aa.add(new Book());
//////        aa.get(0);
//////       // aa.add(new Person())   //在编译阶段，发现类型不匹配，编译器报错
//        int i=0;
//        int j=0;
//        System.out.println(i==j);
//        String s="abc";
//        Integer w=Integer.valueOf(1);
//        boolean b=true;
//        Boolean b1=new Boolean(b);
//    }
//
//
//
//}
import java.util.Collection;
import java.util.ArrayList;
import java.util.Arrays;
public class Demo {
    public static void main(String[] args) {
        Collection<String> list = new ArrayList<>();
        System.out.println(list.size());
        System.out.println(list.isEmpty());
        list.add("我");
        list.add("爱");
        list.add("Java");
        list.add("Java");
        System.out.println(list.size());
        System.out.println(list.isEmpty());
        Object[] array = list.toArray();
        System.out.println(Arrays.toString(array));
        for (String s : list) {
            System.out.println(s);
        }
        list.remove("爱");
        for (String s : list) {
            System.out.println(s);
        }
        list.clear();
        System.out.println(list.size());
        System.out.println(list.isEmpty());
ArrayList <Integer> lists=new ArrayList<>();
lists.add(0,1);
lists.set(0,1);
    }
}

