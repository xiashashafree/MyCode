package HashTest;

import java.util.Calendar;

public class HashBucket {
    int capacity;//哈希表容量
    int size;//元素个数
    private static final double HASH_LOAD_FACTOR = 0.75;//哈希负载因子
    Node[] table;
    public static class Node{
        int key;
        int value;
        Node next;
        public Node(int key,int value){
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    public HashBucket(int capacity){
        if(capacity<10){
            capacity = 10;
        }
        this.capacity = capacity;
        this.table = new Node[capacity];
    }
    private int hashFunc(int key){
        return key % capacity;
    }
    public boolean put(int key,int value){

        int bucketNo = hashFunc(key);
        Node cur = table[bucketNo];
        while(cur != null){
            if(cur.key == key){
                cur.value = value;
                return true;
            }
            cur = cur.next;
        }
        Node node = new Node(key,value);
        node.next = table[bucketNo];
        table[bucketNo] = node;
        ++size;
        return true;
    }

    public boolean containsKey(int key){
        int bucketNo = hashFunc(key);
        Node cur = table[bucketNo];
        while(cur != null){
            if(cur.key == key){
                return true;
            }
            cur =cur.next;
        }
        return  false;
    }
    public boolean containsValue(int value){
        for(int i =0;i<capacity;i++){
            Node cur = table[i];
            while(cur != null){
                if(cur.value == value){
                    return true;
                }
                cur =cur.next;
            }
        }
        return false;
    }

    public boolean remove(int key){
        int bucketNo = hashFunc(key);
        Node cur = table[key];
        Node pre = null;
        while(cur!=null){
            if(cur.key == key){
                if(pre == null){
                    table[bucketNo] = cur.next;
                }else{
                    pre.next = cur.next;
                }
                --size;
                return true;
            }
            cur =cur.next;
        }
        return false;
    }

    public void resize(){
        if((size/capacity)*10 > HASH_LOAD_FACTOR*10){
            int newCapacity  = capacity*2;

            Node[] newTable = new Node[newCapacity];
            for (int i = 0; i <capacity; i++) {
                Node cur = table[i];
                while(cur!=null){
                    table[i] = cur.next;
                    int bucketNo = cur.key%newCapacity;
                    cur.next = newTable[i];
                    newTable[i] = cur;
                    cur = table[i];
                }

            }
            table = newTable;
            capacity = newCapacity;

        }
    }
}
