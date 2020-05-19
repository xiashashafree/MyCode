package AOneQuestionPerDay;

public class SimpleLeastCommonAncestors {
    public static int getLCA(int a, int b) {
        if(a == 1 || b == 1){
            return 1;
        }

        while(a != b)
        {
            if(a > b)
                a /= 2;
            else
                b /= 2;
        }
        return a;

    }

    public static void main(String[] args) {

        System.out.println( getLCA(34,32));
    }


}
