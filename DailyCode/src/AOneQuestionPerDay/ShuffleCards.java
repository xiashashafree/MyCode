package AOneQuestionPerDay;

import java.util.Scanner;
public class ShuffleCards{
    private static void gameStart(int[] arr1,int K){
        int[] arr2 = new int[arr1.length];
        int index = arr2.length-1;
        int N=arr1.length/2;
        while(K>0){
            for(int i=arr1.length-1; i>=N;i--){

                arr2[index--] = arr1[i];
                arr2[index--] = arr1[i-N];
            }
            int[] temp = arr1;
            arr1 = arr2;
            arr2 = temp;
            index = arr2.length-1;
            K--;
        }

        System.out.print(arr1[0]);

        for(int i =1;i<arr1.length;i++){
            System.out.print(" "+arr1[i]);
        }
        System.out.println();


    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        for(int i=0;i<count;i++){
            int N = sc.nextInt();
            int K = sc.nextInt();
            int[] arr = new int[2*N];

            for(int j=0;j<arr.length;j++){
                arr[j] = sc.nextInt();
            }

            gameStart(arr,K);

        }
    }
}
