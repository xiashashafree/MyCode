package AOneQuestionPerDay;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class T9 {
    public List<String> getValidT9Words(String num, String[] words) {
        List<String> ret = new ArrayList<>();
        if(num == null || num.length() == 0|| words == null || words.length==0){
            return ret;
        }
        HashMap<Character,String> map = new HashMap<>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        for(String s:words){
            char[] ch = s.toCharArray();
            char[] ch1 = num.toCharArray();
            boolean flag = true;
            for(int i=0;i<ch.length;i++){
                if(!map.get(ch1[i]).contains(ch[i]+"")){
                    flag = false;
                    break;
                }
            }
            if(flag){
                ret.add(s);
            }
        }
        return ret;

    }
}
