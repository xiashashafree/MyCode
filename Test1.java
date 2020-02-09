import java.util.Arrays;

public class Test1 {

    public static int[] sortArrayByParity(int[] A) {
        int[] B = new int[A.length];
        int left = 0;
        int right = B.length - 1;

        for (int i = 0; i < A.length; i++) {
            if (A[i] % 2 == 0) {
                B[left++] = A[i];
            }
            if (A[i] % 2 != 0) {
                B[right--] = A[i];
            }
        }
        return B;
    }

    public static int pivotIndex(int[] nums) {
//    int index=0;
//    for (int i = 0; i < nums.length; i++) {
//        int sum1=0;
//        for (int j = 0; j < i; j++) {
//            sum1=sum1+nums[j];
//        }
//        int sum2=0;
//        for (int j = nums.length; j >i ; j--) {
//            sum2=sum2+nums[j];
//        }
//        if(sum1==sum2){
//            index=i;
//            break;
//        }
//
//    }
//    if(index!=0){
//        return index;
//
//    }
//    return -1;
        int index = -1;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            int sum1 = 0;
            for (int j = 0; j < i; j++) {
                sum1 = sum1 + nums[j];
            }
            if (sum - sum1 - nums[i] == sum1) {
                index = i;
                break;
            }

        }
        return index;
    }

    /**
     * 给定一组字符，使用原地算法将其压缩。
     * 压缩后的长度必须始终小于或等于原数组长度。
     * <p>
     * 数组的每个元素应该是长度为1 的字符（不是 int 整数类型）。
     * <p>
     * 在完成原地修改输入数组后，返回数组的新长度。
     */
    public int compress(char[] chars) {
        int count = 0;
        return 0;
    }


    //你的朋友正在使用键盘输入他的名字 name。偶尔，在键入字符 c 时，按键可能会被长按，而字符可能被输入 1 次或多次。
    //
    //你将会检查键盘输入的字符 typed。如果它对应的可能是你的朋友的名字（其中一些字符可能被长按），那么就返回 True。
    //


    public static boolean isLongPressedName(String name, String typed) {
        StringBuilder sb = new StringBuilder();
        char c = 0;
        for (int i = 0; i < typed.length(); i++) {
            char ch = typed.charAt(i);
            if (ch != c) {
                sb.append(ch);
                c = ch;
            }
        }
        typed = sb.toString();
        for (int i = 0; i < typed.length(); i++) {
            if (!name.contains(typed.charAt(i) + "")) {
                return false;
            }
        }
        return true;

    }


    public static String reverseOnlyLetters(String S) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);
            if (ch <= 'Z' && ch >= 'A' || ch <= 'z' && ch >= 'a') {
                sb.append(ch + "");
            }

        }
        sb.reverse();
        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);
            if (!(ch <= 'Z' && ch >= 'A' || ch <= 'z' && ch >= 'a')) {
                sb.insert(i, ch);
            }

        }

        return sb.toString();
    }

    public boolean isPalindrome(int x) {
        String str = x + "";

        int left = 0;
        int right = str.length() - 1;
        while (left < right) {

            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right++;

        }

        return true;
    }


    public static int lengthOfLastWord(String s) {
        String[] str = s.split(" ");
        if (str.length == 0) {
            return 0;
        }
        s = str[str.length - 1];
        for (int i = 0; i < s.length(); i++) {

            if (Character.isDigit(s.charAt(i))) {
                return 0;
            }
        }
        return s.length();
    }

    public static int myAtoi(String str) {
        str = str.replace(" ", "");


        return 0;
    }

    public static int findUnsortedSubarray(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }


        int[] order = nums.clone();
        Arrays.sort(order);


        int left = 0;
        int right = nums.length - 1;

        int leftIndex = 0;
        while (order[left] == nums[left] || order[right] == nums[right]) {

            if (order[left] == nums[left]) {
                left++;
            }

            if (order[right] == nums[right]) {

                right--;
            }

            if (left >= nums.length - 1 || right < 0) {
                break;
            }

        }
        System.out.println(left + " " + right);
        if (right == 0 && left == order.length - 1) {
            return 0;
        }
        return (right - left + 1);
//        for (int i = 0; i < nums.length; i++) {
//
//            System.out.print(nums[i]+" ");
//
//        }


    }




    //给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
    //最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
    //你可以假设除了整数 0 之外，这个整数不会以零开头
    public static int[] plusOne(int[] digits) {
        int ca = 0;
        if (digits[digits.length - 1] < 9) {
            digits[digits.length - 1] += 1;
        } else {
            digits[digits.length - 1] = 0;
            ca = 1;
            for (int i = digits.length - 2; i >= 0; i--) {
                if (digits[i] == 9) {
                    digits[i] = 0;


                } else {
                    digits[i] += 1;
                    ca = 0;
                    break;
                }
            }
        }
        System.out.println(ca);
        if (ca == 1) {
            int[] res = new int[digits.length + 1];
            res[0] = 1;

            for (int i = 0; i < digits.length; i++) {
                res[i + 1] = digits[i];

            }
            return res;
        }
        return digits;
    }


    //如果数组中不存在目标值，返回 [-1, -1]
    //示例 1:
    //输入: nums = [5,7,7,8,8,10], target = 8
    //输出: [3,4]
    //示例 2:
    //输入: nums = [5,7,7,8,8,10], target = 6
    //输出: [-1,-1]
    //给定一个按照升序排列的整数数组 nums，和一个目标值 target。
    // 找出给定目标值在数组中的开始位置和结束位置。
    public static int[] searchRange(int[] nums, int target) {

        int[] res={-1,-1};
        for (int i = 0; i <nums.length ; i++) {

            if(nums[i]==target){
                res[0]=i;
                break;
            }
        }
        if(res[0]==-1){
            return res;
        }
        for (int i = nums.length-1; i >=0; i--) {
               if(nums[i]==target){
                   res[1]=i;
                   break;
               }
        }

        return res;


    }
    public static void main(String[] args) {


    }


}

