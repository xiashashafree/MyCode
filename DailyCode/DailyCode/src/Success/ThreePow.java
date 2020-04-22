package Success;

/***
 * 4^3=13+15+17+19
 * 讲一个数拆解为几个奇数
 */
import java.util.*;
public class ThreePow{
    private static String ret(int num){
        int mid = ((int)(Math.pow(num,3)))/num;
        List<Integer> list = new ArrayList<>();
        int left1=0,right1=0;
        if(mid%2 == 0){
            left1=mid-1;
            right1=mid+1;
        }else{
            list.add(mid);
            left1 = mid-2;
            right1 = mid+2;
        }
        int temp = left1;
        for(int i = 0;i<num/2;i++){
            list.add(0,temp);
            temp = temp-2;
        }
        temp =right1;
        for(int i =0;i<num/2;i++){
            list.add(temp);
            temp = temp+2;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<list.size();i++){
            if(i == list.size()-1){
                sb.append(list.get(i));
            }else{
                sb.append(list.get(i)+"+");
            }
        }
        return sb.toString();
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextInt()){
            int num = sc.nextInt();
            System.out.println(ret(num));
        }
    }
}
