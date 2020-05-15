package AOneQuestionPerDay;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BigIntegerCompare {
    
        public static void main1(String[] args){
            Scanner sc = new Scanner(System.in);
            int size = sc.nextInt();
            sc.nextLine();
            PriorityQueue<String> q = new PriorityQueue<>(size,new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    if(o1.length()>o2.length())
                        return 1;
                    if(o1.length()<o2.length())
                        return -1;

                    return o1.compareTo(o2);
                }
            });
            for(int i=0;i<size;i++){
                String s = sc.nextLine();
                q.offer(s);
            }
            while(q.size()>0){

                System.out.println(q.poll());
            }


        }

        public static int bit(int num){

            int count = 0;
            while(num!=0){
               count++;
               num = num&(num-1);
            }
            return count;
        }


        private static int ret(int num){
            int count = 0;
            while(num != 0){
                ++count;
                num = num&(num-1);
            }
            return count;
        }
        public static void main(String[] args){

            Scanner sc = new Scanner(System.in);
            while(sc.hasNext()){
                String s = sc.nextLine();
                char[] ch = s.toCharArray();
                for(int i=0;i<ch.length;i++){
                    int num = ch[i]-'\0';
                    if(ret(num) % 2 == 0){
                        System.out.print("1");
                    }else{
                        System.out.print("0");
                    }

                    String s1 = Integer.toBinaryString(num);
                    s1 = String.format("%07d", Integer.parseInt(s1));
                    System.out.println(s1);
                }
            }
        }


}
