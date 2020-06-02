package Review;

public class HeapSort {

    private void shiftDown(int[] arr,int parent,int size){
        int child = parent * 2+1;
        while(child < size){
            //小堆
            if(child+1<size && arr[child+1]>arr[child]){
                ++child;
            }
            if(arr[child]>arr[parent]){
                int temp = arr[child];
                arr[child] = arr[parent];
                arr[parent] = temp;
            }else{
                break;
            }
            parent = child;
            child = parent*2+1;
        }
    }
    public void sort(int[] arr,int size){
        int lastLeafP = (size-2)>>1;

        //1.建成大顶堆
        for (int i = lastLeafP; i >=0; i--) {
            shiftDown(arr,i,size);
        }

        //2.将大顶堆的堆顶元素与堆的最后一个元素交换，然后再次维护大顶堆
        int end = size-1;
        while(end>0){
            swap(arr,end,0);

            shiftDown(arr,0,end);
            end -- ;
        }

    }
    private void swap(int[] arr,int i1,int i2){
        int temp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = temp;
    }

    public static void main(String[] args) {
        HeapSort heap = new HeapSort();
        int[] arr = {9,3,6,4,7,5,2,1};
        heap.sort(arr,8);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
