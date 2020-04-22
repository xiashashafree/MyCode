package OJPratice;
import java.util.Scanner;
import java.util.Stack;

public class Main1 {

    public static String find(String s){
        if(s == null || s.length() == 0){
            return null;
        }
        int[][] arr=new int[1][2];
        char[] ch = s.toCharArray();
        int left , right = 0;
        for (int i = 0; i < ch.length ; i++) {
            if(Character.isDigit(ch[i])){
                left=i;
                right=i;
                i++;
                while(i<ch.length && Character.isDigit(ch[i])){
                    i++;
                    right++;
                }
                if(right - left > (arr[0][1]-arr[0][0])){
                    arr[0][0] = left;
                    arr[0][1] = right;
                }

            }
        }

        return s.substring(arr[0][0],arr[0][1]+1);

    }

    public static boolean chkParenthesis(String A, int n) {
        if(null == A || A.length() == 0){
            return false;
        }
        Stack<Character> s = new Stack<>();
        for (int i = 0; i < n; i++) {
            char c = A.charAt(i);
            if(c == '('){
                s.push(c);
            }else if(c == ')'){
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
//        Scanner sc = new Scanner(System.in);
//        while(sc.hasNext()){
//            String s=sc.nextLine();
//            System.out.println(find(s));
//        }

        System.out.println( chkParenthesis("(a)()()",7));

    }
}
