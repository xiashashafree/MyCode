package AOneQuestionPerDay;

import java.util.TreeMap;

/***
 * 翻转单词顺序
 * 左旋转字符串
 */
public class FlipString {
    public static void resverse(char[] ch,int begin,int end){

        while(begin<end){
            char c= ch[begin];
            ch[begin] = ch[end];
            ch[end] = c;
            begin++;
            end -- ;
        }

    }

    public static String  resWord(String s){
        char[] ch = s.toCharArray();
        int begin = 0;
        int end = 0;
        while(begin<s.length() && end<s.length()){
            if(ch[begin] != ' '){
                while(end<s.length() &&ch[end] != ' '){
                        end++;
                }
                resverse(ch,begin,end-1);
                begin = end;
            }else{
                begin++;
                end++;
            }


        }

        resverse(ch,0,ch.length-1);
        return new String(ch);
    }

    public static String leftRes(String s,int index){
        char[] ch = s.toCharArray();
        resverse(ch,0,index);
        resverse(ch,index+1,ch.length-1);
        resverse(ch,0,ch.length-1);
        return new String(ch);
    }
    public static void main(String[] args) {
        String s = "I am a Student";
        System.out.println( resWord(s));

    }
}
