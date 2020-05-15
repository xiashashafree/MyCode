package AOneQuestionPerDay;
import java.util.*;
public class 和为S的连续正数序列 {



        private ArrayList<Integer> ret(int start,int end){
            ArrayList<Integer> ret = new ArrayList<>();
            for(int i=start;i<=end;i++){
                ret.add(i);
            }
            return  ret;
        }
        public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
            ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
            int mid = (sum+1)>>1;
            int small = 1;
            int big = 2;
            int add = small + big;
            while(small<mid){
                if(add<sum){
                    big++;
                    add+=big;
                }else if(add> sum){
                    add-=small;
                    small++;
                }else{
                    ret.add(ret(small,big));
                    big++;
                    add+=big;
                }
            }
            return ret;
        }
}
