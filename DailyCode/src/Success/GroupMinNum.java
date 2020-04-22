package Success;

/***
 * 组个最小数
 */
import java.util.*;
public class GroupMinNum{
    private static List<Integer> ret(int[] array){
        List<Integer> list = new ArrayList<>();
        for(int i =1;i<array.length;i++){
            while(array[i] > 0){
                list.add(i);
                array[i]--;
            }
        }
        while(array[0] >0 ){
            list.add(1,0);
            array[0]--;
        }
        return list;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[] array = new int[10];
        while(sc.hasNext()){
            for(int i =0;i<10;i++){
                array[i] = sc.nextInt();
            }
            List<Integer> l = ret(array);
            for(int i = 0;i<l.size();i++){
                System.out.print(l.get(i));
            }
            System.out.println();
        }

    }
}
