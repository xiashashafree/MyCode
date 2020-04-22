package OJPratice;

public class ReplaceSpace {

//    public String replaceSpace(StringBuffer str) {
//        StringBuffer ss = new StringBuffer();
//        for (int i = 0; i < str.length(); i++) {
//            char ch=str.charAt(i);
//            if(ch == ' '){
//                ss.append("%20");
//            }else ss.append(ch + "");
//        }
//        return ss.toString();
//    }

    public static String replaceSpace(String str) {

        int count = 0;
        for(char c:str.toCharArray()){
            if(c==' ')
                count++;
        }
        char[] ch = new char[str.length()+count*3];
        int p1 = str.length()-1;
        int p2 = ch.length-1;
        while(p1>=0){
            if(str.charAt(p1) ==' '){
                ch[p2--]='0';
                ch[p2--]='2';
                ch[p2--]='%';
                p1--;
                p2--;
            }else{
                ch[p2]=str.charAt(p1);
                p1--;
                p2--;
            }
        }
        str =new String(ch);
        return str;

}

    public static void main(String[] args) {
        System.out.println(replaceSpace("we are one"));
    }
}
