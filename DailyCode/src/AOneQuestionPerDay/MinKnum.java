package AOneQuestionPerDay;

import java.util.ArrayList;

public class MinKnum {

        private void swap(int[] arr,int index1,int index2){
            int temp = arr[index1];
            arr[index1] = arr[index2];
            arr[index2] = temp;
        }
        private int partion(int[] arr,int left,int right){
            int begin = left;
            int end = right-1;
            int key = arr[right-1];
            while(begin < end){
                while(begin<end && arr[begin]<=key){
                    begin++;
                }
                while(begin<end && arr[end]>=key){
                    end--;
                }
                if(begin<end){
                    swap(arr,begin,end);
                }
            }
            if(begin != right-1){
                swap(arr,begin,right-1);
            }
            return begin;

        }

        public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
            ArrayList<Integer> list = new ArrayList<>();
            if(k>input.length || k<=0){
                return list;
            }

            int left = 0;
            int right = input.length;
            int index = partion(input,left,right);
            while(index != k-1){
                if(index >=k){
                    right = index;
                    index = partion(input,left,right);
                }else{
                    left =  index+1;
                    index = partion(input,left,right);
                }
            }
            for(int i=0; i<k; i++){
                list.add(input[i]);
            }
            return list;

    }
}
