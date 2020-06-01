package AOneQuestionPerDay;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

class MaxQueue {
    Queue<Integer> q ;

    Deque<Integer> max;

    public MaxQueue() {
        q = new LinkedList<>();
        max = new LinkedList<>();
    }

    public int max_value() {
        if(max.isEmpty()){
            return -1;
        }
        return max.peek();
    }

    public void push_back(int value) {
        q.offer(value);

        while(max.size()>0){
            int num = max.peekLast();
            if(num<value){
                max.pollLast();
            }else{

                break;
            }
        }
        max.offer(value);


    }

    public int pop_front() {
        if(q.isEmpty()){
            return -1;
        }
        int num = q.poll();
        if(max.peek().equals(num)){
            max.poll();
        }
        return num;

    }
}

/**
 * Your MaxQueue object will be instantiated and called as such:
 * MaxQueue obj = new MaxQueue();
 * int param_1 = obj.max_value();
 * obj.push_back(value);
 * int param_3 = obj.pop_front();
 */
