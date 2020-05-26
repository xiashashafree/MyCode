package AOneQuestionPerDay;

import java.util.ArrayList;
import java.util.List;

/**
 * 生成格雷码
 * 返回格雷码的二进制数值
 */
public class GrayCode {
    public static String[] grayCode1(int n){
        if(n == 1){
            return new String[]{"0","1"};
        }else{
            String[] str = grayCode1(n-1);
            String[] ret = new String[str.length*2];
            for (int i = 0; i < str.length; i++) {
                ret[i] = "0"+str[i];
                ret[ret.length-1-i] = "1"+str[i];
            }
            List<Integer> list = new ArrayList<>(10);
            list.set(3,1);
            return ret;
        }
    }

    /**
     * 返回格雷码的十进制数值
     * @param n
     * @return
     */

    public static List<Integer> grayCode(int n) {

        if(n <= 1){
            List<Integer> list = new ArrayList<>();
            if(n<1){
                list.add(0);
                return list;
            }
            list.add(0);
            list.add(1);
            return list;
        }else{
            List<Integer> list = grayCode(n-1);

            int[] ret = new int[list.size()*2];
            for(int i=0;i<list.size();i++){
                ret[i] = list.get(i);
                ret[ret.length-1-i] = (1<<n-1)+list.get(i);
            }
            List<Integer> list1 = new ArrayList<>();
            for(int i=0;i<ret.length;i++){
                list1.add(ret[i]);
            }
            return list1;
        }
    }

    public List<Integer> grayCode2(int n) {
        /**
         关键是搞清楚格雷编码的生成过程, G(i) = i ^ (i/2);
         如 n = 3:
         G(0) = 000,
         G(1) = 1 ^ 0 = 001 ^ 000 = 001
         G(2) = 2 ^ 1 = 010 ^ 001 = 011
         G(3) = 3 ^ 1 = 011 ^ 001 = 010
         G(4) = 4 ^ 2 = 100 ^ 010 = 110
         G(5) = 5 ^ 2 = 101 ^ 010 = 111
         G(6) = 6 ^ 3 = 110 ^ 011 = 101
         G(7) = 7 ^ 3 = 111 ^ 011 = 100
         **/
        List<Integer> ret = new ArrayList<>();
        for(int i = 0; i < 1<<n; ++i)
            ret.add(i ^ i>>1);
        return ret;
    }

    public static int jump(int n){

        //一次跳两阶或一次跳一阶台阶
        if(n==1)
            return 1;
        if(n==2)
            return 2;
        return  jump(n-1)+jump(n-2);
    }

    public static void main(String[] args) {
//        grayCode(2);
        jump(7);
    }
}
