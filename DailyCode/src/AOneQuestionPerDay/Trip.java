package AOneQuestionPerDay;

import java.util.HashMap;
import java.util.List;

public class Trip {


        public String destCity(List<List<String>> paths) {
            HashMap<String,String> map = new HashMap<>();
            for(List<String> list:paths){
                map.put(list.get(0),list.get(1));
            }
            String s = map.get(paths.get(0).get(0));
            String last = s;
            while(s!= null){
                last = s;
                s = map.get(s);

            }
            return last;
        }

}
