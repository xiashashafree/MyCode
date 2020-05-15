package AOneQuestionPerDay;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class UglyNum {

    public int GetUglyNumber_Solution(int index) {
        if(index<=0){
            return 0;
        }

        int[] arr = new int[index];
        int a =0,b=0,c=0;
        arr[0] = 1;
        for(int i=1;i<index;i++){
            int n2 = arr[a]*2;
            int n3 = arr[b]*3;
            int n5 = arr[c]*5;
            arr[i] = Math.min(Math.min(n2,n3),n5);
            if(arr[i] == n2) a++;
            if(arr[i] == n3) b++;
            if(arr[i] == n5) c++;
        }
        return arr[index-1];
    }


    public static void main(String[] args) {
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(null,0);
        System.out.println(map.get(null));
//        Map<Integer,Integer> m = new HashMap<>();
//        m.put(null,"hhh");
    }

//    public V put(K key,V value){
//        return putVal(hash(key),key,value,false,true);
//    }
//
//    final V putVal(int hash,K key,V value,boolean onlyIfAbsent,
//                   boolean evict){
//        Node<K,V>[] tab;
//        Node<K,V> p;
//        int n,i;
//        //1.若桶是空的，则进行扩容
//        if((tab = table) == null || (n = tab.length) == 0)
//            n = (tab = resize()).length;
//
//        //2.(n-1) & hash--->计算桶号，如果当前桶没有结点，直接插入
//        if((p = tab[ i = (n-1) & hash]) == null)
//            tab[i] = new Node(hash,key,value,null);
//        else{
//            Node<K,V> e;K k;
//
//            if(p.hash == hash &&
//                    ((k = p.key) == key || (key != null && key.equals(k)))){
//
//            }
//        }
//
//    }
}
