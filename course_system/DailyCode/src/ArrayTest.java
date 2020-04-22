
public class ArrayTest {
    /**旋转数组的最小值*/
    public int minNumberInRotateArray(int [] array) {
        if(array.length==0){
            return -1;
        }
        int left=0;
        int right=array.length-1;
        while(left<right){
            int mid=(left+right)/2;
            if(array[mid]<array[right]){
                right=mid;
            }else if(array[mid]>array[right]){
                left=mid+1;
            }else{
                right=right-1;
            }
        }
        return array[right];

    }
}