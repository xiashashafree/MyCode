import java.util.ArrayList;
import java.util.List;

public class Triangle {
    public static List<List<Integer>> yangTrangle(int numRows){
        List<List<Integer>> list=new ArrayList<>();
        for(int i=0;i<numRows;i++){
            List<Integer> list1=new ArrayList<>();
            for(int j=0;j<=i;j++){
                if(j==0||i==j){
                    list1.add(1);
                }
                else{
                    list1.add(list.get(i-1).get(j-1)+list.get(i-1).get(j));
                }
            }
            list.add(list1);
        }
        return list;
    }

    public static void main(String[] args) {
        List<List<Integer>> list=yangTrangle(5);
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j <list.get(i).size() ; j++) {
                System.out.print(list.get(i).get(j)+" ");

            }
            System.out.println();

        }
    }
}
