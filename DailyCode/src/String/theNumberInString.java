package String;

/**
 * 字符串中数字子串求和
 * 例如：A1BC2DE33F     返回数字和36
 */
public class theNumberInString {

    public static int add(String s){
        if(s == null){
            return 0;
        }
        int num = 0;
        int sum = 0;
        boolean op = true;
        char[] ch = s.toCharArray();
        for (int i = 0; i <ch.length; i++) {
            int c = ch[i]-'0';
            if(c<0||c>9){//非数字字符
                sum = sum+num;
                num = 0;
                if(ch[i] == '-'){//正负号的逻辑判断
                    if(i-1>-1 && ch[i-1] == '-'){
                        op = !op;
//                        op = true;
                    }else{
                        op = false;
                    }
                }
            }else{
                num = num*10+(op ? c:-c);
            }
        }
        sum=sum+num;

        return sum;

    }



    public static void main(String[] args) {

        System.out.println(add("AC2D-34HU---3"));
    }
}