package AOneQuestionPerDay;

import java.util.*;
public class Train{
    private static void swap(List<Integer> list,int index1,int index2){
        int temp = list.get(index1);
        list.set(index1,list.get(index2));
        list.set(index2,temp);
    }
    private static boolean isRight(List<Integer> pushlist,List<Integer> poplist){
        Stack<Integer> s = new Stack<>();
        int index = 0;
        for(int i=0;i<pushlist.size();i++){
            s.push(pushlist.get(i));
            while(index<pushlist.size() && !s.empty() && s.peek().equals(poplist.get(index)) ){
                s.pop();
                index++;
            }
        }

        return s.empty();
    }
    static List<List<Integer>> L ;
    private static  void order(List<Integer> list,int index){
        if(index == list.size()-1){
            List<Integer> ret = new ArrayList<>();
            for(int i=0;i<list.size();i++){
                ret.add(list.get(i));
            }

            L.add(ret);

            return;
        }else{
            for(int i=index;i<list.size();i++){
                if(i!=index){
                    swap(list,i,index);
                }

                order(list,index+1);
                if(i!=index){
                    swap(list,i,index);
                }
            }
        }
    }
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int num = sc.nextInt();
            List<Integer> list = new ArrayList<>();
            for(int i=0;i<num;i++){
                list.add(sc.nextInt());
            }
            L =new ArrayList<>();
            order(list,0);
            List<List<Integer>> L1 =new ArrayList<>();
            for(List<Integer> l:L){
                if(isRight(list,l)){
                    L1.add(l);
                }
            }
            for(int i=0;i<L1.size();i++){
                List<Integer> l = L1.get(i);
                for(int j=0;j<l.size();j++){
                    System.out.print(l.get(j)+" ");
                }
                System.out.println();
            }
            L.clear();

        }
    }

}
