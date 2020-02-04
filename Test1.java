public class Test1 {

    public static int[] sortArrayByParity(int[] A) {
        int [] B= new int [A.length];
        int left=0;
        int right=B.length-1;

        for (int i = 0; i < A.length; i++) {
            if(A[i]%2==0){
                B[left++]=A[i];
            }
            if(A[i]%2!=0){
                B[right--]=A[i];
            }
        }
        return B;
    }
public static int pivotIndex(int[] nums){
//    int index=0;
//    for (int i = 0; i < nums.length; i++) {
//        int sum1=0;
//        for (int j = 0; j < i; j++) {
//            sum1=sum1+nums[j];
//        }
//        int sum2=0;
//        for (int j = nums.length; j >i ; j--) {
//            sum2=sum2+nums[j];
//        }
//        if(sum1==sum2){
//            index=i;
//            break;
//        }
//
//    }
//    if(index!=0){
//        return index;
//
//    }
//    return -1;
    int index=-1;
    int sum=0;
    for (int i = 0; i < nums.length; i++) {
        sum=sum+nums[i];
    }
    for (int i = 0; i <nums.length ; i++) {
        int sum1=0;
        for (int j = 0; j <i ; j++) {
            sum1=sum1+nums[j];
        }
            if(sum-sum1-nums[i]==sum1){
            index=i;
            break;
        }

    }
    return index;
}


    public static void main(String[] args) {
        int[] A={4,3,2,1};
        A=sortArrayByParity(A);
        for (int i = 0; i <A.length ; i++) {
            System.out.print(A[i]+" ");

        }
        System.out.println();
    }
}
