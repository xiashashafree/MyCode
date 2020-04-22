package heap;

import java.util.Arrays;

interface Comp
{
    public int compare(int left, int right);
}

// 按照小于的方式进行比较
class Less implements Comp{
    // 0: left == right
    // > 0: left > right
    // < 0: left < right
    public int compare(int left, int right){
        return  left - right;
    }
}

class Greater implements Comp{
    public int compare(int left, int right){

        return  right - left;
    }
}

public class MyPriorityQueue {
    public int[] array;
    private int size;
    private Comp com = null;

    public MyPriorityQueue(Comp com) {
        array = new int[11];
        this.com = com;
    }

    public MyPriorityQueue(int capacity, Comp com) {
        if (capacity < 1) {
            capacity = 11;
        }
        this.com = com;
        array = new int[capacity];
    }

    public MyPriorityQueue(int[] arr, Comp com) {
        array = new int[arr.length];
        for (int i = 0; i < arr.length; ++i) {
            array[i] = arr[i];
        }
        size = array.length;
        this.com = com;
        int lastNorLeaf = (array.length - 2) >> 1;

        for (int i = lastNorLeaf; i >= 0; i--) {
            shiftDown(i);
        }

    }

    /**
     * 向下调整
     */
    private void shiftDown(int parent) {
        int child = parent * 2 + 1; //child始终标注最小的孩子


        while (child < size) {
            if (child + 1 < size && com.compare(array[child+1], array[child]) < 0) {
                child = child + 1;
            }

            if (com.compare(array[child],array[parent]) < 0) {
                swap(parent, child);
                parent = child;
                child = parent * 2 + 1;
            } else {
                return;
            }
        }
    }

    private void swap(int parent, int child) {
        int tmp = array[parent];
        array[parent] = array[child];
        array[child] = tmp;
    }

    int peek() {
        return array[0];
    }

    boolean offer(int x) {
        //检测是否需要扩容
        grow();
        array[size++] = x;
        shiftUp(size - 1);
        return true;
    }

    int poll() {
        int ret = array[0];
        swap(0, size - 1);
        size--;
        shiftDown(0);
        return ret;
    }

    private void grow() {
        if (size >= array.length) {
            int oldCapacity = array.length;
            int newCapacity = oldCapacity + (oldCapacity < 64 ? oldCapacity + 2 : oldCapacity >> 1);
            array = Arrays.copyOf(array, newCapacity);
        }
    }

    boolean isEmpty() {
        return 0 == size;
    }

    /**
     * 向上调整
     */
    private void shiftUp(int child) {
        int parent = (child - 1) >> 1;

        while (parent >= 0) {
            if (com.compare(array[child],array[parent]) < 0) {
                swap(parent, child);

                child = parent;
                parent = (child - 1) >> 1;
            } else {
                return;
            }

        }
    }

    int size() {
        return size;
    }

    void clear() {
        size = 0;
    }


    public static void main(String[] args) {
        int array[] = {5, 3, 7, 1, 4, 6, 8, 0, 2};

        MyPriorityQueue mp = new MyPriorityQueue(array, new Greater());
        mp.offer(9);
        System.out.println(mp.peek());
        System.out.println(mp.size());

        mp.offer(-1);
        System.out.println(mp.peek());
        System.out.println(mp.size());

        mp.poll();
        System.out.println(mp.peek());
        System.out.println(mp.size());

        mp.clear();
        if (mp.isEmpty()) {
            System.out.println("空");
        } else {
            System.out.println("fe");
        }
    }
}
