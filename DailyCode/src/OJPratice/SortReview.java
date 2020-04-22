package OJPratice;

import java.util.Stack;

public class SortReview {
    /**
     * 直接插入
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)
     * 算法稳定
     * 适用于数据个数较少或数据序列接近有序
     */
    public static void insertSort(int[] array) {

        for (int i = 1; i < array.length; i++) {
            //[0,i-1]为有序区间 array[i]为待插入的元素
            int end = i - 1;//[0,end]，已经排好序的区间
            int key = array[i];
            while (end >= 0 && key < array[end]) {
                array[end + 1] = array[end]; //将比key大的数字向后移动
                end--;//end指向的是与key比较的元素 在key之前
            }
            array[end + 1] = key;
        }
    }

    /**
     * 二分查找
     * 稳定
     */
    public static void binarySort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int left = 0;
            int right = i;
            while (left < right) {
                int mid = left + ((right - left) >> 1);
                if (key <= array[mid]) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            //搬移元素
            for (int j = i; j > left; j--) {
                array[j] = array[j - 1];
            }
            array[left] = key;
        }
    }

    /**
     * 希尔排序
     * 时间复杂度：O(N)~O(N^2)
     * 空间复杂度：O(1)
     * 适用于元素比较杂乱，序列比较多
     * 不稳定
     */
//    public static void shellSort(int[] array) {
//        int gap = array.length;
//        while (gap > 1) {
//            gap = gap / 3 + 1;
//            for (int i = gap; i < array.length; i += gap) {
//                int key = array[i];
//                int end = i - gap;
//
//                while (end >= 0 && key < array[end]) {
//                    array[end + gap] = array[end];
//                    end = end - gap;
//                }
//                array[end + gap] = key;
//            }
//        }
//
//    }
    public static void shellSort(int[] array){
        int gap = array.length;
        while(gap>1){
            gap = gap/3+1;
            for (int i = gap; i < array.length; i+=gap) {
                int key = array[i];
                int end = i-gap;
                while(end>=0 && array[end] >= key){
                    array[end+gap] = array[end];
                    end-=gap;
                }
                array[end+gap] = key;
            }
        }
    }

    /**
     * 选择排序
     * 时间复杂度为O(N^2)
     * 空间复杂度为O(1)
     * 不稳定
     */
    public static void selectSort(int[] array) {
        int begin = 0;
        int end = array.length - 1;

        while (begin < end) {
            int minPos = begin;
            int maxPos = end;

            for (int i = begin + 1; i <= end; i++) {
                if (array[i] < array[minPos]) {
                    minPos = i;
                }
                if (array[i] > array[maxPos]) {
                    maxPos = i;
                }
            }
            if (maxPos != end) {
                swap(array, maxPos, end);
            }
            if (end == minPos) {
                //最小的元素在end位置上，但是此时maxPos位置的最大元素已经被换到end位置上，
                //此时最小的元素被换到了maxPos位置上
                minPos = maxPos;
            }
            if (minPos != begin) {
                swap(array, begin, minPos);
            }
            begin++;
            end--;
        }
    }

    public static void xuanze(int[] array){
         int begin = 0;
         int end = array.length-1;

         while(begin<end){
             int minPos = begin;
             int maxPos = begin;
             for(int i=begin+1;i<=end;i++){
                 if(array[i]<array[minPos]){
                     minPos=i;
                 }

                 if(array[i]>array[maxPos]){
                     maxPos=i;
                 }
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

    /**
     * 堆排序
     * 时间复杂度：
     * 空间复杂度：
     * 不稳定
     */
    public static void buildHeap(int[] array) {
        int lastNorLeaf = (array.length - 2) >> 1;
        for (int i = lastNorLeaf; i >= 0; i--) {
            shiftDown(array, i, array.length);
        }

        for (int i = array.length - 1; i > 0; i--) {
            swap(array, 0, i);
            shiftDown(array, 0, i);
        }

    }

    public static void shiftDown(int[] array, int parent, int size) {
        int child = (parent * 2) + 1;

        while (child < size) {
            if (child + 1 < size && array[child] < array[child + 1]) {
                child = child + 1;
            }
            if (array[parent] >= array[child]) {
                break;
            } else {
                swap(array, parent, child);
                parent = child;
                child = (parent * 2) + 1;
            }
        }
    }

    private static int partion1(int[] array, int left, int right) {
        int key = array[right - 1];
        int begin = left;
        int end = right - 1;
        while (begin < end) {
            while (begin < end && array[begin] <= key) {
                begin++;

            }
            while (begin < end && array[end] >=key) {
                end--;
            }

            if (begin < end) {
                swap(array, begin, end);
            }


        }
        if (begin != right - 1) {
            swap(array, begin, right - 1);
        }

        return begin;
    }
     private static int partion2(int[] array,int left,int right){
            int key=array[right-1];
            int begin=left;
            int end=right-1;
            while(begin<end){
                while(begin<end && array[begin]<=key){
                    begin++;
                }
                if(begin<end){
                    array[end]=array[begin];
                }
                while(begin<end && array[end]>=key){
                    end--;
                }
                if(begin<end){
                    array[begin]=array[end];
                }
            }
           array[begin]=key;
            return begin;
     }

     private static int partion3(int[] array,int left,int right){
        int prev=left-1;
        int cur=left;
        int key=array[right-1];
        while(cur<right){
            if(array[cur]<key && ++prev!=cur){
                swap(array,cur,prev);
            }
            cur++;
        }
        if(++prev != right-1){
            swap(array,prev,right-1);
        }
        return prev;
     }
    public static void quickSort(int[] array, int left, int right) {
        if (right - left > 1) {
            int div = partion1(array, left, right);
            quickSort(array, left, div);
            quickSort(array, div + 1, right);
        }
    }

    /***
     * 快排非递归
     */
    public static void quickSortNor(int[] array){
        Stack<Integer> s=new Stack<>();

        s.push(array.length);
        s.push(0);

        while(!s.empty()){
            int left=s.pop();
            int right=s.pop();

            if(right-left>1){
                int div=partion1(array,left,right);
                s.push(right);
                s.push(div+1);
                s.push(div);
                s.push(left);
            }
        }

    }

//    public static void mergeData(int[] array,int left,int mid,int right,int[] temp){
//        int begin1=left;
//        int begin2=mid;
//        int index=left;
//        while(begin1<mid && begin2<right){
//            if(array[begin1]<=array[begin2]){
//                temp[index++]=array[begin1++];
//            }else{
//                temp[index++]=array[begin2++];
//            }
//        }
//        while(begin1<mid){
//            temp[index++]=array[begin1++];
//        }
//
//        while(begin2<right){
//            temp[index++]=array[begin2++];
//        }
//        System.arraycopy(temp,0,array,left,right-left);
//    }
//    private static void mergeSort(int[] array,int left,int right,int[] temp){
//        if(right-left>1){
//            int mid=left+((right-left)>>1);
//            mergeSort(array,left,mid,temp);
//            mergeSort(array,mid,right,temp);
//            mergeData(array,left,mid,right,temp);
//            System.arraycopy(temp,left,array,left,right-left);
//        }
//    }
//
//    public static void merger(int[] array){
//        int[] temp=new int[array.length];
//        mergeSort(array,0,array.length,temp);
//    }
//    public static void mergeNor(int[] array){
////        int gap=1;
////        for (int i = 0; i < ; i++) {
////
////        }
//    }

    /***
     * 归并排序
     * 时间复杂度：O(NlogN)
     * 空间复杂度：O(N)
     * 稳定：
     * 使用场景：
     * @param array
     */

    static int count = 0;
    public static void merge(int[] array){
        int[] temp = new int[array.length];

        mergeSort(array, 0,array.length,temp);
    }
    private static void mergeSort(int[] array,int left,int right,int[] temp){
        if(right - left >1){
            int mid = left+((right-left)>>1);
            mergeSort(array,left,mid,temp);
            mergeSort(array,mid,right,temp);
            mergeData(array,left,mid,right,temp);
//            System.arraycopy(temp,left,array,left,right-left);
        }
    }

    private static void mergeData(int[] array,int left,int mid,int right,int[] temp){
        int p1 = mid-1;
        int p2 = right-1;
        int index = right-1;

        while(p1 >= left && p2 >= mid){
            if(array[p1] > array[p2]){
                temp[index--] = array[p1--];
                count = p2-mid+1;
            }else{
                temp[index--] = array[p2--];
            }
        }
        while(p1>=left){
            temp[index--] = array[p1--];
        }
        while(p2>=mid){
            temp[index--] = array[p2--];
        }

         System.arraycopy(temp,left,array,left,right-left);
    }


    /***
     * 归并非递归
     * @param array
     */
    public static void mergeSortNor(int[] array){
        int[] temp = new int[array.length];
        int gap = 1;
        while(gap < array.length){
            for (int i = 0; i < array.length  ; i +=2*gap) {

                int left = i;
                int mid = i +gap;
                int right = mid+gap;

                if(mid >array.length){
                    mid = array.length;
                }

                if(right > array.length){
                    right = array.length;
                }

                mergeData(array,left,mid,right,temp);
            }

            gap = gap <<1;
        }

    }
    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] array={3,3,6,8,7,4,2,1,3,9,5};
        printArray(array);
//        insertSort(array);
//        binarySort(array);
//        shellSort(array);
//        selectSort(array);
//        buildHeap(array);
        quickSort(array, 0, array.length);
//        quickSortNor(array);
//        mergeSortNor(array);
        printArray(array);
    }
}
