package AOneQuestionPerDay;

public class Excel {
    public int titleToNumber(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }

        char[] ch = s.toCharArray();
        int power = 1;
        int sum = 0;
        for(int i=ch.length-1;i>=0;i--){
            int cur = ch[i]-'@';
            sum = sum+cur*power;
            power*=26;
        }
        return sum;
    }
}
