package OJPratice;

import java.util.Stack;

public class Parenthesis {
    public static boolean chkParenthesis(String A, int n) {
        if(null == A || A.length() == 0){
            return false;
        }
        Stack<Character> s = new Stack<>();
        for (int i = 0; i < n; i++) {
            char c = A.charAt(i);
            if(c == '('){
                s.push(c);
            }else{
                if(s.empty()){
                    return false;
                }else{
                    s.pop();
                }
            }
        }
        return s.empty();
    }

    public static void main(String[] args) {
        String s=")";

        System.out.println(  chkParenthesis(s,1));
        String s1= null;
        System.out.println(s1);
    }
}
