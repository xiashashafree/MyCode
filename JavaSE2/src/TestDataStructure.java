
import java.util.Queue;
import java.util.LinkedList;
import java.util.Stack;
import java.lang.Integer;




/** 数组实现循环队列*/
class MyCircularQueue {
    int[] arr;
    int front=0;
    int rear=0;
    int size;
    int capatity;

    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        capatity=k;
        arr=new int[k];
        size=0;

    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if(isFull()){
            return false;
        }

        arr[rear]=value;
        rear=(rear+1)%capatity;
        size++;

        //错误
        // if(size==capatity){
        //     rear=0;
        // }

        return true;
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if(isEmpty()){
            return false;
        }
        front=(front+1)%capatity;
        size--;

        //错误
        // if(size==0){
        //     front=0;
        //     rear=0;
        // }

        return true;

    }

    /** Get the front item from the queue. */
    public int Front() {
        if(isEmpty()){
            return -1;
        }
        return arr[front];
    }

    /** Get the last item from the queue. */
    public int Rear() {
        if(isEmpty()){
            return -1;
        }
        //错误 return arr[front+size];
        return arr[(front+size-1)%capatity];

    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        if(size==0){
            return true;
        }
        return false;
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        if(size==capatity){
            return true;
        }
        return false;
    }
}



class Solution1 {
    public boolean backspaceCompare(String S, String T) {
        Stack<Character> s1=new Stack<>();
        Stack<Character> s2=new Stack<>();
        for(int i=0;i<S.length();i++){
            char ch=S.charAt(i);
            if(ch=='#'){
                if(!s1.empty()){
                    s1.pop();
                }

            }else{
                s1.push(ch);
            }
        }
        for(int i=0;i<T.length();i++){
            char ch1=T.charAt(i);

            if(ch1=='#'){
                if(!s2.empty()){
                    s2.pop();
                }
            }else{
                s2.push(ch1);
            }
        }
        while(!s1.empty()&&!s2.empty()){
            if(!(s1.pop().equals(s2.pop()))){
                return false;
            }
        }
        if(s1.empty()&&s2.empty()){
            return true;
        }
        return false;
    }
}


/**最小栈（可以查看栈内最小值）*/
class MinStack {
    Stack<Integer> s1;
    Stack<Integer> s2;


    /** initialize your data structure here. */
    public MinStack() {
        //存放数据
        s1=new Stack<Integer>();
        //存放最小值
        s2=new Stack<Integer>();
    }

    public void push(int x) {
        s1.push(x);
        if(s2.empty()||x<=s2.peek()) {
            s2.push(x);
        }
    }

    public void pop() {
        if(s1.empty()){
            return;
        }
        if(s1.peek().equals(s2.peek())){

            s2.pop();
        }
        s1.pop();
    }

    public int top() {
        if(s1.empty()){
            return -1;
        }
        return s1.peek();
    }

    public int getMin() {
        if(s2.empty()){
            return  -1;
        }
        return s2.peek();

    }
}


/**括号匹配问题*/
class Solution {
    public boolean isValid(String s) {
        Stack<Character> s1=new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch=s.charAt(i);
            if(ch=='('||ch=='['||ch=='{'){
                s1.push(ch);
            }
            else{
                if(s1.isEmpty()){
                    return false;
                }
                else {
                    char chleft=s1.peek();
                    if((ch==')'&&chleft=='(')||(ch==']'&&chleft=='[')||(ch=='}'&&chleft=='{')){
                        s1.pop();
                    }else{
                        return false;
                    }

                }
            }

        }
        if(s1.isEmpty()){
            return true;
        }
        return false;
    }
}


/**两个队列实现一个栈*/
class MyStack {

    Queue<Integer> q1;
    Queue<Integer> q2;
    /** Initialize your data structure here. */
    public MyStack() {
        q1=new LinkedList<Integer>();
        q2=new LinkedList<Integer>();
 
    }

    /** Push element x onto stack. */
    public void push(int x) {
        q1.offer(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {

        int size=q1.size();
        while(size>1){
            q2.offer(q1.poll());
            size--;

        }
        int ret=q1.poll();
        Queue<Integer> tmp=q2;
        q2=q1;
        q1=tmp;
        return ret;
    }

    /** Get the top element. */
    public int top() {

        int size=q1.size();
        while(size>1){
            q2.offer(q1.poll());
            size--;
        }
        int ret=q1.poll();
        q2.offer(ret);
        Queue<Integer> tmp=q2;
        q2=q1;
        q1=tmp;
        return ret;

    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        if(q1.isEmpty()){
            return true;
        }
        return false;
    }
}

/**两个栈实现一个队列*/
class MyQueue {


    Stack<Integer> s1;
    Stack<Integer> s2;

    /** Initialize your data structure here. */
    public MyQueue() {

        s1=new Stack<Integer>();
        s2=new Stack<Integer>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        s1.push(x);

    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {

        if(s2.empty()){
            int size=s1.size();
            while(size>0){
                s2.push(s1.pop());
                size--;
            }
        }
        return s2.pop();
    }

    /** Get the front element. */
    public int peek() {

        if(s2.empty()){
            int size=s1.size();
            while(size>0){
                s2.push(s1.pop());
                size--;
            }
        }
        return s2.peek();

    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        if(s1.empty()&&s2.empty()){
            return true;
        }
        return false;
    }
}



public class TestDataStructure {
    public static int calPoints(String[] ops) {
        Integer point=0;
        Stack<String> s=new Stack<>();
        for (int i = 0; i < ops.length ;i++) {
            if(ops[i].equals("D")){
                point=point+(Integer.getInteger(s.peek())*2);
            }
            else if(ops[i].equals("C")){
                point=point-Integer.getInteger(s.pop());
            }
            else{
                s.push(ops[i]);
                point=point+Integer.getInteger(s.peek());
            }

        }
        return point;

    }
    public static int evalRPN(String[] tokens) {
        Stack<String> s=new Stack<>();

        for (int i = 0; i < tokens.length; i++) {
            if(!s.empty()){
                System.out.println(i+" "+ s.peek());
            }

            if(tokens[i].equals("+")||tokens[i].equals("-")
                    ||tokens[i].equals("*")||tokens[i].equals("/")){
                int num2=Integer.parseInt(s.pop());
                int num1=Integer.parseInt(s.pop());
                System.out.println("---"+num1+" "+num2);

                if(tokens[i].equals("+")){
                    s.push(String.valueOf(num1+num2));
                }
                if(tokens[i].equals("-")){
                    s.push(String.valueOf(num2-num1));
                }
                if(tokens[i].equals("*")){
                    s.push(String.valueOf(num1*num2));
                }
                if(tokens[i].equals("/")){
                    s.push(String.valueOf((int)(num1/num2)));
                }

            }
            else{
                s.push(tokens[i]);
            }

        }
        return Integer.parseInt(s.peek());
    }
    public static void main(String[] args) {
//        Stack<Integer> s1=new Stack<Integer>();
//        s1.isEmpty();
//        s1.push(1);
//        System.out.println( s1.peek());
//        s1.empty();
//        s1.peek();
//        ArrayList<Integer> arr=new ArrayList<Integer> (10);
        //["4","13","5","/","+"]
String[] s={"4","13","5","/","+"};
        System.out.println(evalRPN(s));


    }
}


class T1{

    public int calPoints(String[] ops) {
        Integer point=0;
        Stack<String> s=new Stack<>();
        for (int i = 0; i < ops.length ;i++) {
            if(ops[i].equals("D")){
                point=point+(Integer.parseInt(s.peek())*2);
            }
            else if(ops[i].equals("C")){
                point=point-Integer.parseInt(s.pop());
            }
            else{
                s.push(ops[i]);
                point=point+Integer.parseInt(s.peek());
            }

        }
        return point;

    }

//    public int evalRPN(String[] tokens) {
//          Stack<String> s=new Stack<>();
//        for (int i = 0; i < tokens.length; i++) {
//            if(tokens[i].equals("+")||tokens[i].equals("-")
//                    ||tokens[i].equals("*")||tokens[i].equals("/")){
//                int num2=Integer.parseInt(s.pop());
//                int num1=Integer.parseInt(s.pop());
//
//                if(tokens[i].equals("+")){
//                    s.push(String.valueOf(num1+num2));
//                }
//                if(tokens[i].equals("-")){
//                    s.push(String.valueOf(num2-num1));
//                }
//                if(tokens[i].equals("*")){
//                    s.push(String.valueOf(num1*num2));
//                }
//                if(tokens[i].equals("/")){
//                    s.push(String.valueOf((int)(num2/num1)));
//                }
//
//            }
//            else{
//                s.push(tokens[i]);
//            }
//
//        }
//        return Integer.parseInt(s.peek());
//    }


}