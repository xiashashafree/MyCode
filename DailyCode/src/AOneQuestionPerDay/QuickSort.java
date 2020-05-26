package AOneQuestionPerDay;

import java.util.Stack;

public class QuickSort {

    public static void quickSort(int[] array){
        quickSort(array,0,array.length);
    }
    private static void quickSort(int[] array,int left,int right){
        if(right - left>1){
            int div = partion2(array,left,right);
            quickSort(array,left,div);
            quickSort(array,div+1,right);
        }
    }

    private static int partion1(int[] array,int left,int right){
        int key = array[right-1];
        int begin = left;
        int end = right-1;
        while(begin < end){
            while(begin<end && array[begin]<=key){
                begin++;
            }
            while(begin<end && array[end]>=key){
                end--;
            }
            if(begin<end){
                swap(array,begin,end);
            }
        }

       if(begin != right-1){
            swap(array,begin,right-1);
       }
        return begin;
    }

    private static int partion2(int[] array,int left,int right){
        int key = array[right-1];

        int begin = left;
        int end = right-1;
        while(begin < end){
            while(begin<end && array[begin]<=key){
                begin++;
            }
            if(begin<end){
                swap(array,begin,end);
            }

            while(begin<end && array[end]>=key){
                end--;
            }

            if(begin<end){
                swap(array,begin,end);
            }
        }
        array[begin] = key;
        return begin;
    }
    private static int partion3(int[] array,int left,int right){
        int cur=left;
        int prev = left-1;
        int key = array[right-1];
        while(cur<right){
            if(array[cur]<key && ++prev!=cur){
                swap(array,prev,cur);
            }
            cur++;
        }
        if(++prev != right-1){
            swap(array,prev,right-1);
        }
        return prev;
    }

    public static void quickNor(int[] array){
        Stack<Integer> s = new Stack<>();

        s.push(array.length);
        s.push(0);
        while(!s.empty()){
            int left = s.pop();
            int right = s.pop();
            if(right - left >1){
                int div = partion1(array,left,right);

                s.push(right);
                s.push(div+1);
                s.push(div);
                s.push(left);
            }


        }
    }
    private static void swap(int[] array,int index1,int index2){
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] array={3,6,8,7,4,2,1,9,5};
        quickNor(array);
        printArray(array);
    }
}
