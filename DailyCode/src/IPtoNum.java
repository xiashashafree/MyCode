import java.util.*;
public class IPtoNum {

        private static String toBinary(String s){
            StringBuilder sb = new StringBuilder();
            int num = Integer.parseInt(s);
            int k = 1<<7;//10000000
            for(int i=0;i<8;i++){
                int flag= (k&num)==0 ? 0:1;
                sb.append(flag);
                num = num<<1;
            }
            return sb.toString();
        }
        public static void main1(String[] args){
            Scanner sc = new Scanner(System.in);
            while(sc.hasNext()){
                String IP = sc.nextLine();
                String  num = sc.nextLine();
                String[] ips = IP.split("\\.");
                StringBuilder sb = new StringBuilder();
                for(String s:ips){
                    sb.append(toBinary(s));
                }
                //指定二进制转化为十进制
                System.out.println(Long.parseLong(sb.toString(),2));

                String ret = Long.toBinaryString(Long.parseLong(num));

                int bu = 32-ret.length();
                for(int j=0;j<bu;j++){
                    ret = "0"+ret;
                }
                StringBuilder oo = new StringBuilder();
                for(int i=0;i<4;i++){
                    int index = i*8;
                    oo.append(Integer.parseInt(ret.substring(index,index+8),2)+"");

                    if(i<3)
                        oo.append(".");
                }
                System.out.println(oo.toString());

            }
        }
    public static void main2(String[] args){
        Scanner sc = new Scanner(System.in);
        int dir = 0;//初始化方向为北面
        int num = sc.nextInt();
        String walk = sc.next();
        for(char c:walk.toCharArray()){
            if(c == 'L'){
                num = (num+1)%4;
            }else if(c == 'R'){
                if(num == 0){
                    num =3;
                }else{
                    num = num-1;
                }
            }
        }
        if(num == 0){
            System.out.println("N");
        }else if(num == 1){
            System.out.println("W");
        }else if(num == 2){
            System.out.println("S");
        }else{
            System.out.println("E");
        }
    }
    public static String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0){
            return "";
        }
        int len = strs[0].length();
        int i=0;
        for( ;i<len;i++){
            for(int j=1;j<strs.length;j++){
                if(i<strs[j].length()){
                    if(strs[j].charAt(i) != strs[0].charAt(i)){
                        return strs[0].substring(0,i);
                    }
                }else{
                    return strs[0].substring(0,i);
                }
            }
        }
        return strs[0];
    }

    public static void test(){
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j <5 ; j++) {
                if(j == 3){
                    System.out.println("退出j循环");
                    break;
                }else{
                    System.out.println(i+" "+j);
                }
            }
        }
    }
    public static void main(String[] args) {
//        System.out.println(longestCommonPrefix(new String[]{"flower","flow","flight"}));
        test();
    }
}
