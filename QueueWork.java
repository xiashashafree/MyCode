import java.util.ArrayList;
import java.util.List;

class MyCircularQueue {
    int[] arr;
    int font;
    int rear;
    int capacity;
    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        this.capacity=k;
        arr=new int[k];
        font=0;
        rear=0;
    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
       if(isFull()){
           return false;
       }
       arr[rear]=value;
       rear=(rear+1)%capacity;
       return true;
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
       if(isEmpty()){

           return false;
       }
       font=(font+1)%capacity;
       return true;

    }

    /** Get the front item from the queue. */
    public int Front() {
        if(isEmpty()){
            return -1;
        }
        return arr[font];

    }

    /** Get the last item from the queue. */
    public int Rear() {
        if(isEmpty()){
            return -1;
        }
        return arr[rear];

    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
      return rear==font;
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
       return rear+1==font;
    }
}
public class QueueWork {


}
