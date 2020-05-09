package Review;

public class MyCircularQueue {
    private int[] data;
    private int head;
    private int tail;
    private int size;

    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        data = new int[k];
        head = -1;
        tail = -1;
        size = k;
    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if(isFull()){
            return false;
        }
        if(head == -1){
            head = 0;
        }
        tail = (tail+1)%size;
        data[tail] = value;
        return true;
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if(isEmpty()){
            return false;
        }
        if(head == tail){
            head = -1;
            tail = -1;
            return true;
        }

        head = (head+1)%size;
        return true;
    }

    /** Get the front item from the queue. */
    public int Front() {
        if(isEmpty()){
            return -1;
        }
        return data[head];
    }

    /** Get the last item from the queue. */
    public int Rear() {
        if(isEmpty()){
            return -1;
        }
        return data[tail];
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return head == -1;
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return head == (tail+1)%size;
    }



    

    //The wrong answer
/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
}
/**

public MyCircularQueue(int k) {
    data = new int[k];

    size = k;
}


    public boolean enQueue(int value) {
        if(isFull()){
            return false;
        }


        data[tail] = value;
        tail = (tail+1)%size;
        return true;
    }


    public boolean deQueue() {
        if(isEmpty()){
            return false;
        }


        head = (head+1)%size;
        return true;
    }


    public int Front() {
        if(isEmpty()){
            return -1;
        }
        return data[head];
    }


    public int Rear() {
        if(isEmpty()){
            return -1;
        }
        return data[tail];
    }
*/

 //   public boolean isEmpty() {
//        return head == tail;//这样判断队空是错误的
//    }
/**
 * 类似     1       2        3       4      5        6    size = 6
 *         head
 *         tail
 *        此时head = tail但是队列不为空。
 */



//    public boolean isFull() {
//        return head == (tail+1)%size;
//    }
//