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

    public static void main(String[] args) {

        String [] s={"5","2","C","D","+"};

        System.out.println(calPoints(s));

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