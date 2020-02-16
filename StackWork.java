import java.util.Stack;
import java.lang.Integer;
public class StackWork {
    public static int calPoints(String[] ops){

        Stack<Integer> s2=new Stack();
        for (int i=0;i<ops.length;i++) {
            if(ops[i].equals("D")){
                s2.push(s2.peek()*2);
            }else if(ops[i].equals("C") ){
                s2.pop();
            }else if(ops[i].equals("+")){
                int num=s2.pop();
                int num1=s2.peek();
                s2.push(num);
                s2.push(num+num1);

            }else{
                s2.push(Integer.parseInt(ops[i]));
            }
        }
        int sum=0;
        while(s2.size()>0){

            sum=sum+s2.pop();
        }
        return sum;


    }
    public boolean find132pattern(int[] nums) {
        Stack<Integer> s=new Stack<>();
        for (int i = 0; i <nums.length ; i++) {

                if(s.size()<3) {
                    while (s.size() < 3) {

                        s.push(nums[i]);
                        i++;
                        if (i == nums.length) {
                            break;
                        }
                    }
                }else{

                    int num=s.pop();//a[k]
                    int num1=s.pop();//a[j]
                    int num2=s.pop();//a[i];
                    if(num2<num1&&num2<num&&num<num1){
                        return true;
                    }else  if(num2>num1){

                    }
            }


        }
        return false;

    }

    public class Solution {
        public boolean find132pattern(int[] nums) {
            if (nums.length < 3)
                return false;
            Stack < Integer > stack = new Stack < > ();
            int[] min = new int[nums.length];
            min[0] = nums[0];
            for (int i = 1; i < nums.length; i++)
                min[i] = Math.min(min[i - 1], nums[i]);
            for (int j = nums.length - 1; j >= 0; j--) {
                if (nums[j] > min[j]) {
                    while (!stack.isEmpty() && stack.peek() <= min[j])
                        stack.pop();
                    if (!stack.isEmpty() && stack.peek() < nums[j])
                        return true;
                    stack.push(nums[j]);
                }
            }
            return false;
        }
    }


    public static void main(String[] args) {

        String [] s={"5","2","C","D","+"};



      System.out.println(removeOuterParentheses("((()))(()()()())"));

    }
    public static String removeOuterParentheses(String S) {
        Stack<Character> s=new Stack<>();
        StringBuilder sb=new StringBuilder();
        int count=0;
        for (char c: S.toCharArray()
                ) {
            if(s.empty()){
                s.push(c);
                count++;
            }else {
                if (c == '(') {
                    count++;
                }
                if (c == ')') {
                    count--;
                }
                if (count == 0) {
                    s.pop();
                } else {
                    sb.append(c);
                }

            }
        }

        return sb.toString();

    }
    public static String removeOuterParentheses1(String S) {
       // Stack<Character> s=new Stack<>();
        StringBuilder sb=new StringBuilder();
        int left=0;
        int right=0;

        for (int i = 0; i < S.length(); i++) {

            if(S.charAt(i)=='('){

                left++;

            }
            if(S.charAt(i)==')'){
                right++;
            }
            if(right==left){
                sb.append(S.substring(i+2-left-right,i));
                left=0;
                right=0;

            }


        }

          return sb.toString();
    }



}


//股票价格跨度
class StockSpanner {
    Stack<Integer> s;
    Stack<Integer> s1;

    public StockSpanner() {
        s=new Stack();
        s1=new Stack();
    }

    public int next(int price) {
        int count=1;
        while(!s1.empty()&&s.peek()<=price){
            count+=s1.pop();
            s.pop();
        }
        s1.push(count);
        s.push(price);
        return count;
    }
   
}
