import java.util.*;

public class Solution {
    public static List<Integer> addToArrayForm(int[] A, int K) {
        List<Integer> L=new ArrayList<>();
        int carry=K;
        for(int i=A.length;i>=0;i--){
            if(carry>0){
                if(A[i]+carry>9){


                    L.add(0,(A[i]+carry)%10);
                    carry=(A[i]+carry)/10;
                }else{

                    carry=0;
                    L.add(0,A[i]+carry);
                }
            }else{
                L.add(0,A[i]);
            }
        }
        if(carry>0){

            while(carry!=0){
                L.add(0,carry%10);
                carry=carry/10;
            }


        }
        return L;

    }

    public static int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum=0;
        for (int i=0;i<nums.length;i++){
            if(i%2!=0){
                sum=sum+Math.min(nums[i-1],nums[i]);
            }
        }
        return sum;
    }

    public static int firstUniqChar1(String s) {
        if(s.equals("")){
            return -1;
        }
        char [] ch=s.toCharArray();
        int i=0;
        for (; i < ch.length; i++) {
            int count=0;
            for (int j = 0; j <ch.length ; j++) {

                if(ch[i]==ch[j]){
                    count++;
                }

            }
            if(count==1)
                break;

        }
        if(i==ch.length){
            return -1;
        }
        return i;
    }

    public static int firstUniqChar(String s){
        HashMap<Character,Integer> h=new HashMap<>();
        for (char c: s.toCharArray()
             ) {
            h.put(c,h.getOrDefault(c,0)+1);
        }
        int i = 0;
        for (; i <s.length() ; i++) {
          if( h.get(s.charAt(i))==1){
              break;
          }
        }
        return -1;
    }


    public static void main(String[] args) {
        int[] A={1,2,0,0};
//        List<Integer> L=addToArrayForm(A,34);
//        for (int i:L
//             ) {
//            System.out.print(i);
//        }
//
//        int[] nums={1,3,2,4};
//        System.out.println(arrayPairSum(nums));
//Map m=new HashMap();
String s="cc";

        System.out.println(firstUniqChar(s));


    }
}