import java.util.PriorityQueue;

public class Queue {
    /**设计一个算法，找出数组中最小的k个数。以任意顺序返回这k个数均可。*/
    public int[] smallestK(int[] arr, int k) {
        if(arr==null){
            return null;
        }
        int[]  ret=new int[k];
        if(k!=0){
            PriorityQueue<Integer> p=new PriorityQueue<>();
            for(int i=0;i<arr.length;i++){
                p.offer(arr[i]);
            }

            for(int i=0;i<k;i++){
                ret[i]=p.poll();
            }
        }

        return ret;
    }
}
