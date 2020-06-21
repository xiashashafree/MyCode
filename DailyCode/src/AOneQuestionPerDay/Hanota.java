package AOneQuestionPerDay;

import java.util.List;

/**
 * 汉诺塔问题
 */
public class Hanota {
    public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        int n = A.size();
        ret(A,B,C,n);
    }
    private void ret(List<Integer> A,List<Integer> B,List<Integer> C,int n){
        if(n == 1){//只有一个盘子的话，直接 A->B
            int i = A.remove(A.size()-1);
            C.add(i);
            return;
        }

        ret(A,C,B,n-1);//先将A中的上面n-1个盘子借助C挪到B
        //在将A中最后一个盘子挪到C
        int j = A.remove(A.size()-1);
        C.add(j);
        ret(B,A,C,n-1);//最后将B中的n-1个盘子借助A挪动到C中

    }
}
