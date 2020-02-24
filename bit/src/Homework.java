import java.util.ArrayDeque;
import java.util.Queue;

public class Homework {

    public static String toLowerCase(String str){
        StringBuilder sb=new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char ch=str.charAt(i);
            if(ch<='Z'&&ch>='A'){
                ch=(char)(ch+32);
                sb.append(ch);

            }
        }
        return sb.toString();

    }

    //给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数
    public static void rotate(int[] nums, int k){
//        if(k<0){
//            return;
//        }
//        int [] newNums=new int[nums.length+k];
//        for (int i =0; i <nums.length ; i++) {
//
//            newNums[i+k]=nums[i];
//        }
//        nums=newNums;

        int [] nums1=nums.clone();
        for (int i = 0; i <nums1.length ; i++) {
            System.out.print(nums1[i]+" ");

        }
        System.out.println();
        for (int i = 0; i <nums1.length ; i++) {
            k=k%nums1.length;
            nums[k]=nums1[i];
            k++;

        }
    }
    public static int removeElement(int[] nums, int val) {
        int count=0;
        for(int i=0;i<nums.length;i++) {
            if (nums[i] == val) {
                count++;

            }

                else{
                nums[i-count] = nums[i];
            }


        }
        return nums.length-count;
    }

    //给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。
    // 如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
    //你可以假设数组中无重复元素。

    public static int find(int[] arr,int val){
        int left=0;
        int right=arr.length;
        int index=0;
        while(left<=right){
            if(arr[right]<val){
                index=right+1;
                break;
            }
            if(arr[left]==val||arr[left]>val){
                return left;
            }
            if(arr[right]==val){
                return right;
            }

        }
        return index;
    }

    public static void main(String[] args) {
        System.out.println(toLowerCase("ABC"));
        int [] nums={1,2,3,4,5};
        rotate(nums,2);
        for (int i = 0; i <nums.length ; i++) {
            System.out.print(nums[i]+" ");

        }
        System.out.println();
        int length1=removeElement(nums,1);
        for (int i = 0; i <length1; i++) {
            System.out.print(nums[i]+" ");

        }

    }
}


/**响应次数*/
class RecentCounter {
    Queue<Integer> q1;
    Queue<Integer> q2;

    public RecentCounter() {
        q1=new ArrayDeque<>();
        q2=new ArrayDeque<>();
    }

    public int ping(int t) {

        if(q1.isEmpty()&&q2.isEmpty()){
            q1.offer(t);
            return 1;
        }
        int count=1;


        while(q1.size()>0){
            int num=q1.poll();

            if(num<=t&&num>=t-3000){
                count++;
                q2.offer(num);
            }


        }
        q2.offer(t);
        Queue<Integer> tmp=q1;
        q1=q2;
        q2=tmp;
        return count;
    }
}
/**import java.util.ArrayDeque;
 import java.util.Queue;
 class RecentCounter {
 Queue<Integer> q1;
 // Queue<Integer> q2;

 public RecentCounter() {
 q1=new ArrayDeque<>();

 }

 public int ping(int t) {
 // if(q1.isEmpty()){
 //     q1.offer(t);
 //     return 1;
 // }
 // int count=1;
 // while(q1.size()>0){
 //     int num=q1.poll();
 //     q2.offer(num);
 //     if(num<=t&&num>=t-3000){
 //         count++;
 //     }
 //     else{
 //         break;
 //     }

 // }
 // q2.offer(t);
 // Queue<Integer> tmp=q1;
 // q1=q2;
 // q2=tmp;
 // return count;
 if(q1.isEmpty()){
 q1.offer(t);
 return 1;
 }
 int count=1;

 int size=q1.size();
 for(int i=size;i>0;i--){
 int num=q1.poll();

 if(num<=t&&num>=t-3000){
 count++;
 q1.offer(num);
 }else{

 break;
 }


 }
 q1.offer(t);

 return count;
 }
 }*/
