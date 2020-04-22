package OJPratice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Main5 {

    public static int ret(List<Integer> list){

        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            map.put(list.get(i),map.getOrDefault(list.get(i),0)+1);
        }
        for (int key:map.keySet()) {
            if(map.get(key)>=list.size()/2){
                return map.get(key);
            }
        }
       return -1;
    }



        public static void main(String[] args) {

            Scanner cin = new Scanner(System.in);

            ArrayList<Integer> list = new ArrayList<>();
            while(cin.hasNextInt()){
                list.add(cin.nextInt());
            }

            System.out.println(ret(list));

        }

    }

