package Success;



public class ArrayCount {


    /***
     * 数组中出现频率超过一半的数字
     *
     * 方法一：利用快排，找到下标为array.length/2下标的数返回
     * 若得到的基准值下标小于mid，则中位数在[left,index)中
     * 若得到的基准值下标大于mid，则中位数在[mid+1,right)中
     */
    private static int partion1(int[] array,int left,int right){


        int key=array[right-1];
        int begin = left;
        int end = right-1;

        while(begin < end){
            while(begin<end && array[begin] <= key){
                begin++;
            }

            while(begin < end && array[end] >= key){
                end--;
            }

            if(begin < end){
                swap(array,begin,end);
            }

        }
        //例如 1 4 6 7 5 2 3 4 8 9 这种情况，选择9为基准值时
        if(begin != right-1){
            swap(array,begin,right-1);
        }
        return begin;
    }

    private static void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    public static int count(int[] array) {
        int mid = array.length >> 1;

        int left = 0;
        int right = array.length;
        int index = partion1(array, left, right);
        while (index != mid) {


            if (index > mid) {
                right = index;
                index = partion1(array, left, right);
            } else {
                left = index + 1;
                index = partion1(array, left, right);
            }
        }

        //检测出现次数是否超过一半
        int count = 0;
        for(int i = 0;i<array.length;i++){
            if(array[i] == array[index]){
                count++;
            }
        }
        if(count > array.length/2){
            return array[index];
        }
        return 0;
    }

    /***
     * 方法2
     *用target记录上一次访问的值，count表明当前值出现的次数，
     * 如果下一个值和当前值相同那么count++；
     * 如果不同count--，减到0的时候就要更换新的target值了，
     * 因为如果存在超过数组长度一半的值，那么最后target一定会是该值。
     * 可以这样理解，count的自加和自减就是在描述一种抵消关系，
     * 由于超过一半的出现次数，导致最后的target一定会是该值
     */
    public static int count1(int[] array){
        int count = 1;
        int key = array[0];
        for (int i = 1; i < array.length ; i++) {
            if(array[i] ==key){
                count++;
            }else{
               count --;
            }
            if(count == 0){
                key = array[i];
                count=1;
            }
        }
       return key;
    }


    public static void main(String[] args) {
//        int[] array = {1,2,3,3,4,4};
////        System.out.println(count(array));
//        int[] ret = findThem(array);
//        for (int i = 0; i <ret.length ; i++) {
//            System.out.println(ret[i]);
//        }
        int i=5;
        int s =(i++)+(++i)+(i--)+(--i);
        System.out.println(s);

    }

    /***
     * 数组中只有一个元素出现一次，其他元素均出现两次
     */
    public static int findIt(int[] array){
        int ret = 0;
        for (int i = 0; i < array.length ; i++) {
            ret = ret^array[i];
        }
        return ret;
    }

    /***
     * 数组中有2个元素出现一次，其他元素均出现两次
     *全员异或一次，得到两个数异或的结果，然后看两数的哪一位不同，根据这一位分组异或
     */

    public static int[] findThem(int[] array){
        int ret = 0;
        for (int i = 0; i < array.length ; i++) {
            ret = ret^array[i];
        }
         int temp = 1;
        while((ret&temp) != 0){
            temp<<=1;
        }
        ret = 0;
        int ret1 = 0;
        for (int i = 0; i < array.length; i++) {
            if((array[i]&temp) == 0){
                ret=ret^array[i];
            }else{
                ret1=ret1^array[i];
            }
        }
        int[] arr = {ret,ret1};
        return arr;

    }




}



