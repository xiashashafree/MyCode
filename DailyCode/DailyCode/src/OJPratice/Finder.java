package OJPratice;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Finder {


    public static  int findKth(int[] a, int n, int K) {
        PriorityQueue<Integer> queue=new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });

        for (int i = 0; i < n; i++) {
            queue.offer(a[i]);
        }
        int ret=0;
        while(!queue.isEmpty()){
            if(K==1){
                ret=queue.peek();
            }
            queue.poll();
            K--;
        }
        return ret;




    }

    public static void main(String[] args) {
        int [] arr={3,1,2,4,6,5,7,9};
        System.out.println(findKth(arr,8,3));

        HashMap<Integer,Integer> h=new HashMap<>();

    }
}