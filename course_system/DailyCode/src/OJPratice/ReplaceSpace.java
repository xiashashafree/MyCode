package OJPratice;

public class ReplaceSpace {

    public String replaceSpace(StringBuffer str) {
        StringBuffer ss = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            char ch=str.charAt(i);
            if(ch == ' '){
                ss.append("%20");
            }else ss.append(ch + "");
        }
        return ss.toString();
    }

    public static void main(String[] args) {

    }
}
