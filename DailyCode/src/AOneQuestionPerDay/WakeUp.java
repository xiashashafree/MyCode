package AOneQuestionPerDay;
import java.util.Scanner;
public class WakeUp {


        public static void main(String[] args){
            Scanner sc = new Scanner(System.in);

            int minute = sc.nextInt();
            int wake = sc.nextInt();
            int[] point = new int[minute];//每分钟的兴趣值
            int[] state = new int[minute];//小易的每分钟状态
            for(int i=0;i<minute;i++){
                point[i] = sc.nextInt();
            }
            int val = 0;
            int[] add = new int[minute];
            for(int i=0;i<minute;i++){
                state[i] = sc.nextInt();
                if(state[i] == 0){
                    val=val+point[i];
                }
                add[i] = val;
            }
            //得到最大的额外兴趣值
            int ret = 0;
            int addval = 0;
            for(int i=0;i<minute;i++){
                if(state[i] == 1){
                    ret = ret+point[i];
                }else{
                    int vall = 0;
                    if(i+wake-1>=minute){
                        vall = (i>0) ? add[minute-1]-add[i-1]:add[minute-1];
                    }else{
                        vall = (i>0) ? add[i+wake-1]-add[i-1]:add[i+wake-1];
                    }
                    addval = addval<vall ? vall:addval;
                }
            }
            ret+=addval;
            System.out.println(ret);

        }
}
