package AOneQuestionPerDay;
import java.util.Scanner;
public class IpToNum {


        private static int toNum(int[] num,int index1,int index2){
            int bit = 0;
            int sum = 0;
            for(int i=index2;i>=index1;i--){
                if(num[i]!=0){
                    sum = (int)(sum+(num[i]*(Math.pow(2,bit))));
                }

                bit++;
            }
            return sum;
        }
        //数字转IP地址
        private static  void numtoIP(String s){
            int num = Integer.parseInt(s);
            int[] ret = new int[32];
            int index = 31;
            while(num!=0){
                ret[index--] = num&1;
                num = num>>1;
            }
            int sum = 0;

            for(int i=0;i<4;i++){
                sum = toNum(ret,i*8,i*8+7);
                System.out.print(sum);
                if(i<3){
                    System.out.print(".");
                }
            }
            System.out.println();
        }

        private static void iptoNum(String IP){
            String[] str = IP.split("\\.");

            int[]ret = new int[32];
            int count = 0;
            for (String s:str ){
                int num = Integer.parseInt(s);
                for(int i=count*8+7;i>=count*8;i--){
                    ret[i] = num&1;
                    num>>=1;
                }
                count++;
            }

            int sum = 0;
            sum = toNum(ret,0,ret.length-1);
            System.out.println(sum);
        }
        public static void main(String[] args){
            Scanner sc = new Scanner(System.in);
            while(sc.hasNext()){
                String IP = sc.nextLine();

                String  num = sc.nextLine();
                iptoNum(IP);
                numtoIP(num);
            }
        }

}
