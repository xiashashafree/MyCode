package AOneQuestionPerDay;

import java.util.*;

/***
 * 算法步骤：
 *   1.全排序出所有可能的结果（不一定符合合法出栈顺序）
 *   2.筛选结果，过滤掉不合法的出栈序列
 *   3.输出结果按照字典序排序
 *
 * 对于字符串：例如： abc bca acb    排序结果：abc acb bca  类似查字典的查询方式
 */
public class TrainRight {
    /***
     * 全排序
     * @param array
     */
    static List<int[]> ret ;

    public static void fullSort(int[] arr,int index){
        //index为排列进行到的字符下标

        if(index == arr.length-1){
            int[] temp = arr.clone();
            ret.add(temp);
        }else{
            for(int i=index;i<arr.length;i++){
                swap(arr,i,index);

                //排序n-1位
                fullSort(arr,index+1);

                //注意排序完还要交换回来，否则会影响后面的排序结果
                swap(arr,i,index);

            }
        }
    }
    private static void swap(int[] arr,int index1,int index2){
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    private static boolean isLegal(int[] in,int[] out){
        Stack<Integer> s = new Stack<>();
        int index = 0;
        for(int i=0;i<in.length;i++){
            s.push(in[i]);
            while(index<in.length && !s.empty() && s.peek()==out[index]){
                s.pop();
                index++;
            }
        }
        return s.empty();
    }

    private static String arrayToString(int[] array){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < array.length ; i++) {
            if(i == array.length-1){
                sb.append(array[i]);
            }else{
                sb.append(array[i]+" ");
            }
        }
        return sb.toString();

    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while(s.hasNext()){
            int num = s.nextInt();
            int[] arr = new int[num];
            for (int i = 0; i < num; i++) {
                arr[i] = s.nextInt();
            }
            ret = new ArrayList<>();
            List<String> sort = new ArrayList<>();
            fullSort(arr,0);
            for(int[] array:ret){
                if(isLegal(arr,array)){
                    sort.add(arrayToString(array));
                }
            }
            Collections.sort(sort);
            for (int i = 0; i < sort.size() ; i++) {
                System.out.println(sort.get(i));
            }
            ret.clear();
        }
        PriorityQueue queue = new PriorityQueue();
    }
}
