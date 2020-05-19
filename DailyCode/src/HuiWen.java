import java.util.Scanner;

public class HuiWen {
   /**
    * 判断一个字符串加入一个字符是否会构成回文字符串
    * */
        private static boolean check(String s){
            char[] ch = s.toCharArray();
            int left = 0;
            int right = ch.length-1;
            while(left<right){
                if(ch[left] != '?' && ch[right] != '?'){
                    if(ch[left]!=ch[right]){
                        return false;
                    }
                }
                left++;
                right--;
            }
            return true;
        }
        public static void main(String[] args){
            Scanner sc = new Scanner(System.in);
            while(sc.hasNext()){
                String s = sc.next();
                Boolean is = false;
                for(int i=0;i<=s.length();i++){
                    StringBuilder sb = new StringBuilder(s);
                    sb.insert(i, "?");

                    if(check(sb.toString())){
                        is = true;
                        break;
                    }
                }
                if(is){
                    System.out.println("YES");
                }else{
                    System.out.println("NO");
                }
            }
        }

}
