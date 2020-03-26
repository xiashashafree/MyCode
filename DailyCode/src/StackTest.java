import java.util.Stack;

public class StackTest {

    /**用两个栈实现队列*/
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if(stack1.empty()&&stack2.empty()){
            return -1;
        }
        if(stack2.empty()){
            while(stack1.size()>0){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();


    }
}
