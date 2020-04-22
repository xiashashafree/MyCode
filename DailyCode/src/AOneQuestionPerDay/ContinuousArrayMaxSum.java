package AOneQuestionPerDay;

public class ContinuousArrayMaxSum {

    /***
     * 非递归方法
     */

    public static int  maxSumNor(int[] array){
        int max = 0;
        int lastMax = Integer.MAX_VALUE;
        for (int i = 0; i < array.length; i++) {
            if(max<=0){
                max = array[i];
            }else{
                max = max+array[i];
            }
            if(max > lastMax){
                lastMax = max;
            }
        }
        return lastMax;
    }




    private int getNum(int[] array,int index){
        if(index == 0 || getNum(array,index-1)<0){
            return array[index];
        }
        return getNum(array,index-1)+array[index];
    }
    public int FindGreatestSumOfSubArray(int[] array) {
        int max = Integer.MIN_VALUE;
        for(int i = 0;i<array.length;i++){
            int newMAX = getNum(array,i);
            if( newMAX>max){
                max =  newMAX;
            }
        }
        return max;
    }
}
