package AOneQuestionPerDay;

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

    public static int strToInt(String str) {
        char[] c = str.trim().toCharArray();//去掉首部空格
        if(c.length == 0) return 0;
        int res = 0, bndry = Integer.MAX_VALUE / 10;
        int i = 1, sign = 1;
        if(c[0] == '-') sign = -1;
        else if(c[0] != '+') i = 0;
        for(int j = i; j < c.length; j++) {
            if(c[j] < '0' || c[j] > '9') break;
            if(res > bndry || res == bndry && c[j] > '7') return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            res = res * 10 + (c[j] - '0');
        }
        return sign * (int)res;
    }


    public static void main(String[] args) {
        System.out.println(strToInt("+987"));

    }

}
