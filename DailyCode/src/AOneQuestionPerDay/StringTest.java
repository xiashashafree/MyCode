package AOneQuestionPerDay;

public class StringTest {
    public static boolean match(char[] str, char[] pattern)
    {
        StringBuilder s1 = new StringBuilder(new String(str));
        StringBuilder s2 = new StringBuilder(new String(pattern));
        for(int i=0;i<str.length;i++){
            if(str[i] == '*'){
                s1.setCharAt(i-1,'_');
                s1.setCharAt(i,'_');
            }
        }
        for(int i=0;i<pattern.length;i++){
            if(pattern[i] == '*'){
                s2.setCharAt(i-1,'_');
                s2.setCharAt(i,'_');
            }
        }
        for (int i = 0; i < s1.length(); i++) {
            System.out.print(s1.charAt(i));
        }
        System.out.println();
        for (int i = 0; i < s2.length(); i++) {
            System.out.print(s2.charAt(i));
        }
        System.out.println();
        int len1 = 0,len2 = 0;
        while(len1<s1.length() && len2<s2.length()){
            char c1 = s1.charAt(len1);
            char c2 = s2.charAt(len2);
            if(c1!='.'&&c2!='.'&&c1!='_'&&c2!='_'){
                if(c1 != c2){
                    return false;
                }
            }
            len1++;
            len2++;
        }
        if(len1<s1.length()){
            for(int i=len1-1;i<s1.length();i++){
                if(s1.charAt(i) != '_')
                    return false;
            }
        }
        if(len2<s2.length()){
            for(int i=len2-1;i<s2.length();i++){
                if(s2.charAt(i) != '_')
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(match(new char[]{'a','a','a'},new char[]{'a','b','*','a','c','*','a'}));
    }
}
