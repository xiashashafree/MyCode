import java.util.Stack;

public class Sort {

    public static void swap(int [] array,int index1,int index2){
        int tmp=array[index1];
        array[index1]=array[index2];
        array[index2]=tmp;
    }

    public static void printArray(int[]  array){
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");

        }
        System.out.println();
    }

    /**插入排序  稳定
     * 时间复杂度 最差：O(n2)  最优：O(n)
     * 空间复杂度：O(1)
     * 适用于搬移元素个数较少，序列接近有序
     * */
//    public static void insertSort(int[] array){
//        for (int i = 1; i < array.length; i++) {
//
//            int key=array[i];
//            int end=i-1;
//            while(end>=0&&key<array[end]){
//                array[end+1]=array[end];
//                end--;
//            }
//            array[end+1]=key;
//        }
//    }
    public  static void insertSort(int[] array){
        for (int i = 1; i < array.length ; i++) {
            int key = array[i];
            int end = i-1;
            while(end >=0 && array[end]>=array[key]){
                array[end+1] = array[end];
                end--;
            }
            array[end+1] = key;
        }
    }

    /**希尔排序  不稳定
     * 时间复杂度：
     * 空间复杂度：O(1)
     * 适用场景：元素个数较多 次序比较凌乱的序列
     * */
    public static void shellSort(int[] array){
        //时间复杂度 O(N^1.25)~O(1.6N^1.25)
        int gap=array.length;
        while(gap>1){
            gap=gap/3+1;
            for (int i = gap; i < array.length; i++) {

                int key=array[i];
                int end=i-gap;
                while(end>=0&&key<array[end]){
                    array[end+gap]=array[end];
                    end-=gap;
                }
                array[end+gap]=key;
            }

        }

    }

    /**选择排序：不稳定
     * 时间复杂度：O(N^2)
     * 时间复杂度：O(1)
     * 应用场景：
     * */
    public static void selectSort(int[] array){
        int begin = 0;
        int end = array.length-1;
        while(begin < end){
            int minPos = begin;
            int maxPos = end;
            int index = begin+1;
            while(index <= end){
                if(array[index] < array[minPos]){
                    minPos = index;
                }
                if(array[index] > array[maxPos]){
                    maxPos = index;
                }
                index++;
            }
            if(maxPos != end){
                swap(array,maxPos,end);
            }

            if(minPos == end){
                minPos = maxPos;
            }
            if(minPos != begin){
                swap(array,minPos,begin);
            }
            begin++;
            end--;
        }
    }

    /**堆排序
     * 不稳定
     * 时间复杂度：O(NlogN)，完全二叉树的高度
     * 空间复杂度：O(1)
     * 使用场景：top-k
     */
    private static void shiftDown(int[] array,int parent,int size){
        int child = parent*2+1;
        while(child < size){
            if(child +1 < size && array[child+1] > array[child]){
                child=child+1;
            }

            if(array[parent] < array[child]){
                swap(array,parent,child);
                parent = child;
                child=parent*2+1;
            }else{
                break;
            }
        }

    }

    public static void heapSort(int[] array){
        int lastLeaf = (array.length-2)>>1;
        for (int root = lastLeaf; root >=0; root--) {
            shiftDown(array,root,array.length);
        }

        int end = array.length-1;
        while( end >=0){

            swap(array,0,end);
            shiftDown(array,0,end);
            end--;
        }
    }

    /**
     *快排
     * 时间复杂度：O(NlogN)
     * 空间复杂度：O(logN+N)--->O(N)
     * 应用场景
     * 不稳定
     */

    private static int getMiddleIndex(int[] array,int left,int right){
        int mid = left + (right - left)>>1;
        if(array[left] < array[right-1]){
            if(array[mid] < array[left]){
                return left;
            }else if(array[mid] > array[right-1]){
                return right-1;
            }
            return mid;
        }else{
            if(array[mid]<array[right-1]){
                return right-1;
            }else if(array[mid] >array[left]){
                return left;

            }else{
                return mid;
            }

        }

    }
    private static int partion1(int[] array,int left,int right){
        int mid=getMiddleIndex(array,left,right);


        swap(array,right-1,mid);
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
    //挖坑法

    private static int partion2(int[]  array,int left,int right){
        int begin = left;
        int end = right-1;
        int key = array[right-1];
        while(begin < end){
            while(begin < end && array[begin] <= key){
                begin++;
            }

            if(begin < end){
                array[end] = array[begin];
            }
            while(begin < end && array[end] >= key){
                end--;
            }

            if(begin < end){
                array[begin] = array[end];
            }


        }

        //用key填坑
        array[begin] = key;
        return begin;
    }


    /**前后索引法  [prev+1,cur]*/
    private static int partion3(int[] array,int left,int right){
        int cur = left;
        int prev = left-1;
        int key = array[right-1];
        while(cur < right){
            if(array[cur] < key && ++prev!=cur){
                swap(array,cur,prev);
            }
            cur++;
        }

        if(++prev != right-1){
            swap(array,prev,right-1);
        }
        return prev;
    }


    private static void insertSort(int[] array,int left,int right){
        for (int i = left; i < right; i++) {

            int key=array[i];
            int end=i-1;
            while(end>=0&&key<array[end]){
                array[end+1]=array[end];
                end--;
            }
            array[end+1]=key;
        }
    }

    public static void quickSort(int[] array,int left,int right){
        if(right - left <4){
            insertSort(array,left,right);
        }else {
            int div = partion2(array, left, right);
            quickSort(array, left, div);
            quickSort(array, div + 1, right);
        }
    }

    /**快排非递归*/
    public static void quickSortNor(int[] array){
        Stack<Integer> s=new Stack<>();

        s.push(array.length);
        s.push(0);
        int left=0,right=0;
        while(!s.empty()){
            left = s.pop();
            right = s.pop();
            if(left <right){
                int div=partion1(array,left,right);
                s.push(right);
                s.push(div+1);
                s.push(div);
                s.push(left);
            }

        }
    }

    /***
     * 基数排序
     * 时间复杂度：O（N）
     * 空间复杂度：O（M） M为这批数的范围
     * 稳定
     * @param array
     */
    public static void radixSort(int[] array){
        int minValue = array[0];
        int maxValue = array[0];
        for (int i = 0; i < array.length ; i++) {
            if(array[i] < minValue){
                minValue = array[i];
            }
            if(array[i] > maxValue){
                maxValue = array[i];
            }
        }
        int range = maxValue-minValue+1;
        int[] temp = new int[range];

        // 250 - 400
        for (int i = 0; i < array.length; i++) {
            temp[array[i]-minValue]++;
        }
        int index= 0;
        for (int i = 0; i < range; i++) {
            while(temp[i]--!=0){
                array[index++] = i+minValue;
            }
        }
    }

    /***
     * 冒泡排序
     * 时间复杂度：O(N)
     * 空间复杂度：O(1)
     * 稳定
     * 适用于较有序的序列
     * @param array
     */
    public static void bubbleSort(int[]  array){
        boolean change=false;
        for (int i = 0; i <array.length-1; i++) {
            for (int j = 1; j <array.length; j++) {
                if(array[j-1]>array[j]){
                    swap(array,j-1,j);
                    change=true;
                }
            }
            if(!change){
                return;
            }
        }
    }
    /**
     * 归并排序
     * 稳定
     * 时间复杂度：O(NlogN)
     * 空间复杂度：O(N)
     * @param
     */
    static int count = 0;
    public static void merge(int[]array){
        int[] temp=new int[array.length];

        mergeSort(array,0,array.length,temp);
    }
    private static void mergeData(int[] array,int left,int mid,int right,int[] temp){
        int p1 = mid-1;
        int p2 = right-1;
        int index=right-1;
        while(p1 >= left && p2 >= mid){
            if(array[p1] > array[p2]){
                count = count + p2-mid+1;
                temp[index--] = array[p1--];
            }else{
                temp[index--] = array[p2--];
            }
        }
        for (; p1 >= left; p1--) {
            temp[index--] = array[p1];
        }
        for (; p2 >= mid; p2--) {
            temp[index--] = array[p2];
        }

        System.arraycopy(temp,left,array,left,right-left);


    }

    private static void mergeSort(int[] array,int left,int right,int[] temp){
        if(right - left>1){
            int mid = left+((right-left)>>1);
            //[left,mid)
            mergeSort(array,left,mid,temp);
            //[mid,right)
            mergeSort(array,mid,right,temp);

            //归并
            mergeData(array,left,mid,right,temp);
            System.arraycopy(temp,left,array,left,right-left);

        }
    }

    /**归并非递归*/
    public static void mergeSortNor(int[] array){
        int[] temp=new int[array.length];
        int gap=1;
        while(gap < array.length){
            for (int i = 0; i < array.length ; i+=2*gap) {
                int left=i;
                int mid=left+gap;
                int right=mid+gap;
                if(mid>array.length){
                    mid=array.length;
                }
                if(right>array.length){
                    right=array.length;
                }

                mergeData(array,left,mid,right,temp);
            }
            System.arraycopy(temp,0,array,0,array.length);
            gap<<=1;
        }
    }
    public static void main(String[] args) {
        int[] array={3,2,1,4,0};

                //{1,0,6,3,4,5,2,7,9,8};
//        insertSort(array);
//        printArray(array);
//        shellSort(array);
//        printArray(array);
//        selectSort(array);
//        heapSort(array);
//        quickSort(array,0,array.length);
//       quickSortNor(array);
//        merge(array);
//        System.out.println(count);
//        mergeSortNor(array);
//        radixSort(array);
//        bubbleSort(array);
        printArray(array);
    }
}
