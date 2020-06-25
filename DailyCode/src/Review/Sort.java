package Review;

public class Sort {

    /**
     * 插入排序
     */
    public static void insertSort(int[] array){
        for(int i=1;i<array.length;i++){
            int key = array[i];
            int end = i-1;
            while(end>=0 && key<array[end]){
                array[end+1] = array[end];
                end--;
            }
            array[end+1] = key;
        }
    }

    public static void print(int[] array){
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int[] array = {8,4,1,1,5,7,3,2,6,9};
        insertSort(array);
        print(array);
    }
}
