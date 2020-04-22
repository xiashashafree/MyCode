package AOneQuestionPerDay;

/***
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，
 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
public class OddBeforeEven {
    /***
     * 类似直接插入排序算法思想
     * @param array
     */
    public void reOrderArray(int [] array) {
        for(int i=array.length-1;i>=0;i--){
            if(array[i]%2 == 0){
                int end = i+1;
                int key = array[i];
                while(end<array.length && array[end]%2!=0){
                    array[end-1]=array[end];
                    end++;

                }
                array[end-1] = key;
            }
        }
    }
}
