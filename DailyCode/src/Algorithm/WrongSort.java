package Algorithm;
import java.util.Scanner;
/***
 * 错排算法
 */
public class WrongSort {


        private static float wrong(int num){

            if(num == 1){
                return 0;
            }
            if(num == 2){
                return 1;
            }

            return (num-1)*(wrong(num-1)+wrong(num-2));

        }
        public static void main(String[] args){
            Scanner sc = new Scanner(System.in);
            while(sc.hasNext()){
                int num = sc.nextInt();
                float a = wrong(num);
                float b=1;
                for(int i=1;i<=num;i++){
                    b = b*i;
                }

                float result = (wrong(num)/b)*100;
                System.out.println(String.format("%.2f", result) + "%");
            }
        }

}
