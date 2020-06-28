package AOneQuestionPerDay;

import java.util.Scanner;
import java.util.TreeSet;

public class Yesterday {
    public int[] divingBoard(int shorter, int longer, int k) {

        if(k <=0){
            return new int[0];
        }
        if(shorter == longer){
            return new int[]{k*shorter};
        }
        TreeSet<Integer> ret = new TreeSet<>();
        ret.add(shorter*k);
        ret.add(longer*k);
        int l = 0;
        int s = 0;
        for(int i=0;i<k;i++){
            l+=longer;
            s = 0;
            for(int j=i+1;j<k;j++){
                s+=shorter;
            }
            ret.add(shorter+longer);
        }

        int[] arr = new int[ret.size()];
        int index = 0;
        for(int i:ret){
            arr[index++] = i;
        }
        return arr;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int count = sc.nextInt();
            for(int i=0;i<count;i++){
                String str = sc.next();
                int num = (str.length()/8)+(str.length()%8 == 0? 0:1);


                StringBuilder sb = new StringBuilder();
                for(int j=0;j<num*8;j++){
                    char ch = (j>=str.length()) ? '0':str.charAt(j);
                    sb.append(ch);
                    if(sb.length() == 8){
                        System.out.println(sb.toString());
                        sb = new StringBuilder();
                    }
                }
            }


        }
    }
}
