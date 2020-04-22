package OJPratice;

import java.util.Scanner;
public class Main4{
    public static int[] ret(int[] array){
        if( (array[1]+array[3])%2 != 0 || (array[0]+array[2])%2 != 0){
            return null;
        }
        int[] ret=new int[3];
        ret[0] = (array[0]+array[2])/2;
        ret[1] = (array[1]+array[3])/2;
        ret[2] = array[3]-ret[1];
        if(ret[0]<0 || ret[1]<0 || ret[2]<0){
            return null;
        }
        return ret;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int[] array=new int[4];
            for(int i=0; i<4;i++){
                array[i] = sc.nextInt();
            }
            int[] ret = ret(array);
            if(null == ret){
                System.out.println("No");
            }else{
                for(int i=0;i<3;i++){
                    System.out.print(ret[i]+" ");
                }
                System.out.println();
            }
        }
    }
}