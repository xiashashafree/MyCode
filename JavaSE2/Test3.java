import java.util.Arrays;

class MyArrayList1{
    private int[] arr;
    private int size;
    private int capacity=10;
    public MyArrayList1(int capacity){
        this.arr=new int[capacity];
        this.size=0;
    }
    void addlast(int elm){
        if(size>=capacity-1){
            capacity=(int)(capacity*(1.5));
            arr= Arrays.copyOf(arr,capacity);
        }
        this.arr[size]=elm;
        size++;
    }
    void addHead(int elm){
        if(size>=capacity-1){
            capacity=(int)(capacity*(1.5));
            arr= Arrays.copyOf(arr,capacity);
        }
        for(int i=size-1;i>=0;i--){

            arr[i+1]=arr[i];

        }
        arr[0]=elm;
        size++;

    }
    void add(int index,int elm){
        if(size>=capacity-1){
            capacity=(int)(capacity*(1.5));
            arr= Arrays.copyOf(arr,capacity);
        }
        for(int i=size-1;i>=index;i--){

            arr[i+1]=arr[i];

        }
        arr[index]=elm;
        size++;
    }
    void printArray(){
        for (int i = 0; i <size ; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    int getSize(){
            return size;
    }
    int indexOf(int elm){
        for (int i = 0; i < size; i++) {
            if(arr[i]==elm)
                return i;

        }
        return -1;

    }
    void delete(int elem){
        int index=indexOf(elem);
        for(int i = index; i < size-1; i++) {

            arr[i]=arr[i+1];
        }
        size--;
    }
    boolean contains(int elem){
        for (int i = 0; i < size; i++) {
            if(arr[i]==elem)
                return true;
        }
        return false;
    }
}

public class Test3 {
    public static void main(String[] args) {
        MyArrayList1 list=new MyArrayList1(10);
        list.addlast(1);
        list.addlast(2);
        list.addlast(3);
        list.addlast(4);
        list.addlast(5);
        list.printArray();
        list.add(0,0);
        list.printArray();
        list.addHead(8);
        list.printArray();
        list.delete(4);
        list.printArray();


    }
}
