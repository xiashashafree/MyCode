package AOneQuestionPerDay;

public class SortedArrayNumCount {


    //找到K在数组中第一次出现的位置

        private static int getFirst(int[] array,int k,int left,int right){
            if(left>right){
                return -1;
            }
            int mid = (left+right)/2;
            if(array[mid] == k){
                if( mid>0 &&array[mid-1] != k||mid == 0  ){
                    return mid;
                }else{
                    right = mid-1;
                }
            }else if(array[mid]>k){
                right = mid-1;

            }else{
                left = mid+1;
            }
            return getFirst(array,k,left,right);
        }

        //找到K在数组中最后一次出现的位置
        private static int getLast(int[] array,int k,int left,int right){
            if(left>right){
                return -1;
            }
            int mid = (left+right)/2;
            if(array[mid] == k){
                if(  mid<array.length-1 && array[mid+1] != k||mid == array.length-1){
                    return mid;
                }else{
                    left = mid+1;
                }
            }else if(array[mid]<k){
                left = mid+1;
            }else{
                right = mid-1;
            }
            return getLast(array,k,left,right);
        }
        public static int GetNumberOfK(int [] array , int k) {
            int count = 0;
            int first = getFirst(array,k,0,array.length-1);
            int end = getLast(array,k,0,array.length-1);
            if(first > -1 && end > -1){
                count = end -first+1;
            }
            return count;
        }

    public static void main(String[] args) {
        int[] array = {1,2,3,3,3,3,4,5};
        System.out.println(GetNumberOfK(array,3));
    }

}
