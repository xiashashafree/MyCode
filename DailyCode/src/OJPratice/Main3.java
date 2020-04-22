package OJPratice;

import java.util.Scanner;
public class Main3{

    public static int ret(int[] array,int count){

        int ways = 0;
        for(int i=0; i<count; i++){
            int sum = array[i];
            for(int j=i+1; j<count; j++){

                if(array[i] == 40) {
                    ways++;
                    j = array.length;
                }
                else{
                    sum = sum+array[j];
                    if(sum == 40){
                        ways++;
                        sum = sum-array[j];
                    }else if(sum > 40){
                        sum = sum -array[j];
                    }
                }
            }
        }
        return ways;
    }

    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int count = sc.nextInt();
            int[] array = new int[20];

            for(int i=0; i< count; i++){
                array[i] = sc.nextInt();

            }
            System.out.println(ret(array,count));
        }
    }
}