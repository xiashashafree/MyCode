package AOneQuestionPerDay;
import java.util.*;
public class Vote {

        public static void main(String[] args){
            Scanner sc = new Scanner(System.in);
            while(sc.hasNext()){
                int num = sc.nextInt();
                sc.nextLine();
                String[] s = sc.nextLine().split(" ");
                HashMap<String,Integer> map = new HashMap<>();

                for(String c:s){

                    map.put(c,0);

                }


                int vote = sc.nextInt();
                sc.nextLine();
                String[] s1 = sc.nextLine().split(" ");
                for(String c:s1){
                    if(map.containsKey(c)){
                        map.put(c,map.getOrDefault(c,0)+1);
                        --vote;
                    }
                }
                for(String c:s){
                    if(map.containsKey(c)){
                        System.out.println(c+" : "+map.get(c));

                    }
                }

                System.out.println("Invalid"+" : "+vote);



            }
        }
}
