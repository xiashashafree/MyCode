package heap;

import java.util.Arrays;

public class MyPriorityQueue {
    int []  array;
    int size;

    public MyPriorityQueue(){
        array=new int [11];
    }

    public MyPriorityQueue(int capacity){
        if(capacity<1){
            capacity=11;
        }
        array=new int[capacity];
    }

    public MyPriorityQueue(int [] arr){
        array= Arrays.copyOf(arr,arr.length);
        size=array.length;

        int lastNorLeaf=(array.length-2)>>1;

        for (int i = lastNorLeaf; i >=0 ; i--) {
            shiftDown(i);
        }

    }

    /**向下调整*/
    private void shiftDown(int parent){
        int child=parent*2+1; //child始终标注最小的孩子


        while(child<size){
            if(child+1<size&&array[child+1]<array[child]){
                child=child+1;
            }

            if(array[parent]>array[child]){
                swap(parent,child);
                parent=child;
                child=parent*2+1;
            }else{
                return;
            }
        }
    }

    private void swap(int parent,int child){
        int tmp=array[parent];
        array[parent]=array[child];
        array[child]=tmp;
    }

    int peek(){
      return array[0];
    }

    boolean offer(int x){
        //检测是否需要扩容
        array[size++]=x;
        shiftUp(size-1);
        return true;
    }

    int poll(){
        int ret=array[0];
        swap(0,size-1);
        size--;
        shiftDown(0);
        return ret;
    }

    private void grow(){
        if(size>=array.length){
            int oldCapacity=array.length;
            int newCapacity=oldCapacity+(oldCapacity<64 ? oldCapacity+2:oldCapacity>>1);
            array=Arrays.copyOf(array,newCapacity);
        }
    }

    boolean isEmpty(){
        return 0==size;
    }
    private void shiftUp(int child){
        int parent=(child-1)>>1;

        while(parent>=0){
            if(array[parent]>array[child]){
                swap(parent,child);

                child=parent;
                parent=(child-1)>>1;
            }else{
                return;
            }

        }
    }
    int size(){
        return size;
    }
    void clear(){
        size=0;
    }



    public static void main(String[] args) {
        int[]  arr={5,3,7,1,4,6,8,0,2};

        MyPriorityQueue q=new MyPriorityQueue(arr);
    }
}
