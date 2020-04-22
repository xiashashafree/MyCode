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
    public static void insertSort(int[] array){
        for (int i = 1; i < array.length; i++) {

            int key=array[i];
            int end=i-1;
            while(end>=0&&key<array[end]){
                array[end+1]=array[end];
                end--;
            }
            array[end+1]=key;
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
     * 时间复杂度：
     * 空间复杂度：
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
    public static void main(String[] args) {
        int[] array={5,11,4,6,9,3,2,7,8,1,0,-1,-2,10};
                //{1,0,6,3,4,5,2,7,9,8};
//        insertSort(array);
//        printArray(array);
//        shellSort(array);
//        printArray(array);
//        selectSort(array);
//        heapSort(array);
        quickSort(array,0,array.length);
        printArray(array);
    }
}
