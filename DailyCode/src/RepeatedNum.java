
import java.util.*;

public class RepeatedNum {


        // Parameters:
        //    numbers:     an array of integers
        //    length:      the length of array numbers
        //    duplication: (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
        //                  Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
        //    这里要特别注意~返回任意重复的一个，赋值duplication[0]
        // Return value:       true if the input is valid, and there are some duplications in the array number
        //                     otherwise false
        public boolean duplicate(int numbers[],int length,int [] duplication) {
            if(numbers == null){
                duplication[0] = -1;
                return false;
            }
            HashSet<Integer> set = new HashSet<>();
            for(int num:numbers){
                if(set.contains(num)){
                    duplication[0] = num;
                    return true;
                }else{
                    set.add(num);
                }
            }
            duplication[0] = -1;
            return false;
        }


        public static void main(String[] args){

            Scanner sc =new Scanner(System.in);
            while(sc.hasNextInt()){
                int num = sc.nextInt();
                int pow = num*num;
                int bool = 0;
                while(num!=0){
                    if(pow%10 != num%10){
                        bool = 1;
                        break;
                    }
                    pow = pow/10;
                    num = num/10;
                }
                if(bool == 0){
                    System.out.println("Yes!");
                }else{
                    System.out.println("No!");
                }

            }

        }


}
