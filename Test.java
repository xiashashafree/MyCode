import java.util.Arrays;

public class Test {


    //给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数
    public static void rotate(int[] nums, int k) {
        if (k < 0) {
            return;
        }
        int[] newNums = new int[nums.length + k];
        for (int i = 0; i < nums.length; i++) {

            newNums[i + k] = nums[i];
        }
        nums = newNums;

    }


    public static String toLowerCase(String str) {
        str.toLowerCase();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch <= 'Z' && ch >= 'A') {
                ch = (char) (ch + 32);

            }
        }
        return str;
    }


    public static int isPalindrome(int x) {
        int num = x;
        int count = 0;
        while (num != 0) {
            num = num / 10;
            count++;
        }
        int sum = 0;
        for (int i = 0; i < count; i++) {
            if (i == count - 1) {
                // sum=(int)(sum+x*Math.pow(10.00,i));
                sum = sum + x;
                break;
            }
            int time = (int) Math.pow(10.00, (count - 1 - i));
            int tmp = x / time;
            sum = sum + (int) (tmp * Math.pow(10.00, i));
            x = x - tmp * time;

        }

        return sum;
    }

//public static int ggg(){
//        String s=" ads sed dd ";
//        String[] str=s.split(" ");
//    System.out.println(str[0]);
//
//    for (String s1:str
//         ) {
//        System.out.print(s1+"oo");
//
//    }
//        return 0;
//}

    public static int lengthOfLastWord(String s) {
        int index = s.lastIndexOf(" ");
        if (index == s.length() - 1) {

        }
        return 0;
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums1.length < m + n) {
            Arrays.copyOf(nums1, m + n);
        }
        int count = 0;
        for (int i = 0; i < nums2.length; i++) {
            nums1[m - 1 + i] = nums2[i];
        }
        Arrays.sort(nums1, 0, m + n);

    }

    public static String reverseOnlyLetters(String S) {
        char[] ch = S.toCharArray();
        char[] ch1 = S.toCharArray();
        //  System.out.println();

        int num = ch.length - 1;
        System.out.println(num);
        for (int i = ch.length - 1; i >= 0; i--) {
            if (ch[i] <= 'Z' && ch[i] >= 'A' || ch[i] <= 'z' && ch[i] >= 'a') {
                int j = num - i;
                System.out.println("j" + j);
                if (ch1[j] <= 'Z' && ch1[j] >= 'A' || ch1[j] <= 'z' && ch1[j] >= 'a') {
                    ch1[j] = ch[i];
                    System.out.println(ch[i]);
                    System.out.println("jjj" + ch1[j]);
                } else {
                    ch1[j + 1] = ch[i];
                    System.out.println(ch[i]);
                    System.out.println("kkk" + ch1[j + 1]);
                }
            } else {
                ch1[i] = ch[i];
            }
        }

        return new String(ch1);
    }

    private int m = 0;

    public static void main(String[] args) {
//        long rt=10L;
//        Test t=new Test();
//        t.m=0;
//        char ch=(char)'a'-32;
//        System.out.println(ch);
//
//        System.out.println(isPalindrome(167));
//        int[]  a={3,2,1,2,3};
//        for (int i = 0; i <a.length ; i++) {
//            System.out.print(a[i]+"  ");
//
//        }
//        int [] A={1,2,3};
//       Arrays.sort(A);
////        int[] B=Arrays.copyOf(A,A.length);
//        for (int i = 0; i < A.length; i++) {
//            System.out.println(A[i]);
//
//        }
////        System.out.println(A);
////        System.out.println(reverseOnlyLetters("aff_c_de"));
////        System.out.println(5%3);

//        System.out.println(isPalindrome("12q,Q21"));
        myAtoi(" q 123");
    }

    public static int myAtoi(String str) {

        char [] ch=str.toCharArray();
        char [] nums=new char[ch.length];
        int index=0;
        for (int i = 0; i <ch.length ; i++) {
            if(Character.isDigit(ch[i])||ch[i]=='-'){
                nums[index++]=ch[i];
            }else{
                return 0;
            }


        }
        int sum=0;
        for (int i = index-1; i >=0; i--) {
              if(Character.isDigit(nums[i])) {
                  sum = sum + (int) (Integer.parseInt(nums[i] + "") * Math.pow(10.0, index - 1 - i));
              }
        }
        if(nums[0]=='-'){
            sum=-sum;
        }
        System.out.println(sum);
        return sum;


//        str=str.replace(" ","");
//
//        char [] ch=str.toCharArray();
//
//        int [] nums=new int[ch.length];
//        int index=0;
//        for (int i = 0; i <ch.length ; i++) {
//            if(Character.isDigit(ch[i])){
//                nums[index++]=Integer.parseInt(ch[i]+"");
//            }
//
//        }
//        int sum=0;
//        for (int i = index-1; i >=0; i--) {
//
//            sum=sum+(int)(nums[i]*Math.pow(10.0,index-1-i));
//        }
//        if(ch[0]=='-'){
//            sum=-sum;
//        }
//
//        return sum;



}

    public  static boolean isPalindrome(String s){
        char []  ch=s.toCharArray();
        char []  ch1=new char[ch.length];
        int count=0;
        for (int i = 0; i < ch.length ; i++) {

//            if(Character.isDigit(ch[i])||ch[i]<='Z'&&ch[i]>='A'||ch[i]<='z'&&ch[i]>='a'){
//                ch1[count++]=ch[i];
//            }
            if(Character.isDigit(ch[i])){
                ch1[count++]=ch[i];
            }
            if(ch[i]<='Z'&&ch[i]>='A'||ch[i]<='z'&&ch[i]>='a'){
                ch1[count++]=Character.toLowerCase(ch[i]);
            }

        }
        for (int i = 0; i <=count ; i++) {
            System.out.print(ch1[i]);
        }
        System.out.println();
        int left=0;
        int right=count-1;
        while(left<right){
            if(ch1[left]!=ch1[right]){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
/** public int myAtoi(String str) {
 str=str.replace(" ","");
 char [] ch=str.toCharArray();
 char [] nums=new char[ch.length];
 int index=0;
 for (int i = 0; i <ch.length ; i++) {
 if(Character.isDigit(ch[i])||ch[i]=='-'){
 nums[index++]=ch[i];
 }else{
 return 0;
 }


 }
 int sum=0;
 for (int i = index-1; i >=0; i--) {
 if(Character.isDigit(nums[i])) {
 sum = sum + (int) (Integer.parseInt(nums[i] + "") * Math.pow(10.0, index - 1 - i));
 }
 }
 if(nums[0]=='-'){
 sum=-sum;
 }
 System.out.println(sum);
 return sum;
 }*/

}
