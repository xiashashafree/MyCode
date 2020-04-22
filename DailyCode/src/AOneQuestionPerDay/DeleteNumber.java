package AOneQuestionPerDay;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/***
 * 有一个数组a[N]顺序存放0~N-1，要求每隔两个数删掉一个数，到末尾时循环至开头继续进行，
 * 求最后一个被删掉的数的原始下标位置。以8个数(N=7)为例:
 * ｛0，1，2，3，4，5，6，7｝，0->1->2(删除)->3->4->5(删除)->6->7->0(删除),如此循环直到最后一个数被删除。
 */
public class DeleteNumber {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        while(s.hasNextInt()){
            int num = s.nextInt();
            if(num>1000){
                num = 1000;
            }
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < num; i++) {
                list.add(i);
            }
            int index = 0;

            while(list.size()>0){
                index=(index+2)%list.size();
                list.remove(index);
            }
            System.out.println(list.get(0));

        }
    }
}
