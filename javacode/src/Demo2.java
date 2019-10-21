import java.util.Arrays;

public class Demo2 {
    public static int[]  fun1(int[] arr){
        for(int i=0;i<arr.length;i++)
        {
            arr[i]=arr[i]*2;
            System.out.println(arr[i]);
        }
        return arr;
    }
    public static String fun2(int[]  arr){
        System.out.println("[");
        String s=" ";

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        System.out.println("]");
       return s;
    }

    public static int fun3(int [] arr){
        int max=arr[0];
        for (int i = 0; i <arr.length ; i++) {


            if(max<arr[i])
                max=arr[i];
        }
        return max;
    }
    public static int fun4(int [] arr){
        int min=arr[0];
        for (int i = 0; i <arr.length ; i++) {


            if(min>arr[i])
                min=arr[i];
        }
        return min;
    }
    public static int fun5(int [] arr){
        int sum=0;
        for (int i = 0; i <arr.length ; i++) {



                sum=sum+arr[i];
        }
        return sum/arr.length;
    }
    public static int[] fun6(int [] arr){
        int temp;
        int left=0;
        int right=arr.length-1;
        while(left<right){
            temp=arr[left];
            arr[left]=arr[right];
            arr[right]=temp;
            right--;
            left++;
        }
        return arr;
    }
    public static int[] fun7(int [] arr){
        int temp=0;
        for (int i = arr.length-1; i >0 ; i--) {

            temp=arr[i];
            if(arr[i]%2!=0)
            {
                arr[i]=arr[i-1];
                arr[i-1]=temp;
            }
        }
        return arr;
    }
    public static int find(int [] arr,int left,int right,int key){
      int mid=(right+left)/2;
        while(left<=right){
            if(arr[mid]>key)
            {
                right=mid-1;
                return find(arr,left,right,key);
            }
            if(arr[mid]<key)
            {
                left=mid+1;
                return find(arr,left,right,key);
            }
            if(arr[mid]==key)
            {
                return mid;
            }
            mid=(left+right)/2;
        }
            return -1;
    }
    public static void main(String[] args) {
//       char a='A';
//       char b='B';
//       char c='C';
//        fun(a,b,c,8);
        int [] arr={1,2,3,4,5,6,7,8};
        System.out.println(find(arr,0,7,6));
//        System.out.println (fun3(arr));
//        System.out.println (fun4(arr));
//
//        System.out.println(fun5(arr));
//
//        System.out.println(Arrays.toString(fun6(arr)));
//       int []arr1={2,3,1,4};
   Arrays.sort(arr);
        Arrays.equals(arr,arr);
    }


}
