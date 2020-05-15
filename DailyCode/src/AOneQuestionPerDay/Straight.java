package AOneQuestionPerDay;
import java.util.*;
public class Straight {



        public boolean isContinuous(int [] numbers) {
            if(numbers == null || numbers.length == 0){
                return false;
            }
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            HashSet<Integer> set = new HashSet<>();
            for(int i=0;i<numbers.length;i++){
                if(numbers[i]!=0 && numbers[i]<min){
                    min = numbers[i];
                }
                if(numbers[i]!=0 && numbers[i]>max){
                    max = numbers[i];
                }
                if(numbers[i]!=0){
                    if(!set.add(numbers[i])){
                        return false;
                    }
                }
            }
            return max-min>=5 ? false:true;

        }

}
