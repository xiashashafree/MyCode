package AOneQuestionPerDay;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.HashSet;

public class ToInteger {

//        public static int StrToInt(String str) {
//            if(str == null || str.length() == 0)
//                return 0;
//            int begin = 0;
//            int bit = 1;
//
//
//            str =str.replace(" ","");
//            System.out.println(str);
//            char c = str.charAt(0);
//            if(c != '+'&& c!='-' && (c<'0'||c>57)){
//                return 0;
//            }
//            if(str.charAt(0) == '-'){
//                bit =-1;
//                begin = 1;
//            }else if(str.charAt(0) == '+'){
//                begin = 1;
//            }
//            int ret = 0;
//            int digit = 1;
//            for(int i=str.length()-1;i>=begin;i--){
//                int cur = str.charAt(i)-'0';
//                if(cur>=0 && cur<=9){
//                    int now = (cur*digit)*bit;
//                    if(bit == 1){
//                        if(Integer.MAX_VALUE - ret >= now){
//                            ret = ret+now;
//                        }else{
//                            return 0;
//                        }
//
//                    }else{
//                        if(Integer.MIN_VALUE - ret <= now){
//                            ret = ret+now;
//                        }else{
//                            return 0;
//                        }
//                    }
//                    digit*=10;
//                }
//
//            }
//
//
//            return ret;
//        }

//    public static int strToInt(String str) {
//        char[] c = str.trim().toCharArray();//去掉首部空格
//        if(c.length == 0) return 0;
//        int res = 0, bndry = Integer.MAX_VALUE / 10;
//        int i = 1, sign = 1;
//        if(c[0] == '-') sign = -1;
//        else if(c[0] != '+') i = 0;
//        for(int j = i; j < c.length; j++) {
//            if(c[j] < '0' || c[j] > '9') break;
//            if(res > bndry || res == bndry && c[j] > '7') return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
//            res = res * 10 + (c[j] - '0');
//        }
//        return sign * (int)res;
//    }
    public static int strToInt(String str) {

        char[] ch  = str.trim().toCharArray();
//        for (int i = 0; i < ch.length; i++) {
//            System.out.print(ch[i]);
//        }
        System.out.println();
        if(ch.length == 0){
//            System.out.println("here");
            return 0;
        }
        int begin = 1;
        int flag = 1;
        if(ch[0] == '-'){
            flag = -1;
        }else if(ch[0]!='+'){
            begin=0;
        }
        int ret = 0;
        int beyond = Integer.MAX_VALUE/10;

        for(int i=begin;i<ch.length;i++){
            if(ch[i]<'0' || ch[i]>'9'){
                System.out.println("oooooo");
                break;
            }
            if(ret>beyond || ret == beyond&&ch[i]>'7'){
//                System.out.println("here1");
                return flag==-1 ? Integer.MIN_VALUE:Integer.MAX_VALUE;
            }
            System.out.println(ret);
            ret = ret*10+(ch[i]-'0');
        }
//        System.out.println("here2");
//        System.out.println(ret);
        return flag*(int)ret;
    }

    static HashMap<Integer,TreeNode> map = new HashMap<>();
    static HashSet<Integer> set = new HashSet<>();
    public static void df(TreeNode root){
        if(root.left != null){
            map.put(root.left.val,root); df(root.left);
        }
        if(root.right!=null){
            map.put(root.right.val,root); df(root.right);
        }

       
     }

    
    public static void main(String[] args) {
//        System.out.println(strToInt(" -42"));
//        Integer i=0;
//        Integer j = 1;
//        Pair<Integer,Integer> p = new Pair<>(i,j);
//        p.getKey();



        String s = "aaa;aa;dd;";
        String[] sr = s.split(";");
        for(String s1:sr){
            System.out.println(s1);
        }

        char c1 ='1';
        char c2 = '2';
        System.out.println(Integer.parseInt(""));
        String dd="1w";



    }

}
