package AOneQuestionPerDay;

/***
 * 求旋转数组中的最小值
 * 例：[4,5,6,0,1,2,3]中最小值
 */
public class RotateArray {

    public static int rotateArrar(int[] array){
        //right指向的是小数组区间的值 left指向的是大数组区间的值
        int left = 0;
        int right = array.length-1;
        while(left < right){
            int mid = left+((right-left)>>1);
            if(array[mid] > array[right]){
                //最小值在[mid+1,right]里面
                left = mid+1;
            }else if(array[mid] < array[right]){
                //最小值在[left,mid]
                right = mid;
            }else{
                right--;
            }

        }
        return array[right];
    }

    public static void main(String[] args) {
        int[] arr = {5,6,7,1,2,3,4};

        System.out.println( rotateArrar(arr));
    }
}
