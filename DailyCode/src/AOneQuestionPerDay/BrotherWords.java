package AOneQuestionPerDay;

import java.util.*;

public class BrotherWords {


        private static boolean isBrother(String me,String other){

            if(me.equals(other)){
                return false;
            }
            if(me.length() != other.length()){
                return false;
            }
            char[] c1 = me.toCharArray();
            char[] c2 = other.toCharArray();
            Arrays.sort(c1);
            Arrays.sort(c2);

            return Arrays.equals(c1,c2);
        }
        private static List<String> find(List<String> list,String me){
            List<String> ret = new ArrayList<>();
            int sum = 0;
            for(String s:list){
                if(isBrother(me,s)){
                    ret.add(s);
                }
            }
            return ret;
        }

        public static void main(String[] args){
            Scanner sc = new Scanner(System.in);
            while(sc.hasNext()){
                int num = sc.nextInt();
                List<String> dir = new ArrayList<>();
                for(int i=0;i<num;i++){
                    dir.add(sc.next());
                }
                Collections.sort(dir);
                String me = sc.next();
                int index = sc.nextInt();
                List<String> ret = find(dir,me);
                System.out.println(ret.size());
                if(index<=ret.size()){
                    System.out.println(ret.get(index-1));
                }

            }


        }

}
