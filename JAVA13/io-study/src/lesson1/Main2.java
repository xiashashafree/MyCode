package lesson1;


import java.util.*;

public class Main2{


    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int num = sc.nextInt();
            sc.nextLine();
            int[] ret  = new int[3];//存放甲 胜 负 平的结果数，可推出乙的结果
            int[] jia = new int[3];//甲分别以三种手势胜利的次数 B C J
            int[] yi = new int[3];//乙分别以三种手势胜利的次数   B C J


            for(int i=0;i<num;i++){
                char c1 = sc.next().charAt(0);
                char c2 = sc.next().charAt(0);
//                if(c1 == c2){
//                    ret[1]++;//平
//                }else {
//                    if(c1 == 'B'){
//                        //甲以B胜
//                        if(c2 == 'C'){
//                            ret[0]++;
//                            jia[0]++;
//                        }else{
//                            //乙以J胜  甲 负
//                            ret[2]++;
//                            yi[2]++;
//                        }
//                    }
//                    if(c1 == 'C'){
//                        //甲以C胜 乙负
//                        if(c2 == 'J'){
//                            ret[0]++;
//                            jia[1]++;
//                        }else{
//                            //乙以B胜 甲负
//                            ret[2]++;
//                            yi[0]++;
//
//                        }
//                    }
//                    if(c1 == 'J'){
//                        //甲以J胜  乙负
//                        if(c2 == 'B'){
//                            ret[0]++;
//                            jia[2]++;
//                        }else{
//                            //乙以C胜  甲负
//                            ret[2]++;
//                            yi[1]++;
//                        }
//                    }
//                }
                if(jia[i] == yi[i]) ret[1]++; // 甲 平
                else if(jia[i] == 'J' && yi[i] == 'B'){
                    // 甲  J 赢
                    ret[0]++;
                    jia[2]++;
                }
                else if(jia[i] == 'B' && yi[i] == 'C'){
                    // 甲  B 赢
                    ret[0]++;
                    jia[0]++;
                }
                else if(jia[i] == 'C' && yi[i] == 'J'){
                    // 甲 C 赢
                    ret[0]++;
                    jia[1]++;
                }
                else if(yi[i] == 'J' && jia[i] == 'B'){
                    // 甲负 = 乙J赢
                    ret[2]++;
                    yi[2]++;
                }
                else if(yi[i] == 'B' && jia[i] == 'C'){
                    // 甲负 = 乙B赢
                    ret[2]++;
                    yi[0]++;
                }
                else if(yi[i] == 'C' && jia[i] == 'J'){
                    // 甲负 = 乙C赢
                    ret[2]++;
                    yi[1]++;
                }
            }
            char[] shou = {'B','C','J'};

            System.out.println(ret[0]+" "+ret[1]+" "+ret[2]);
            System.out.println(ret[2]+" "+ret[1]+" "+ret[0]);
            int maxjia = 0;
            int maxyi = 0;//记录甲乙哪个手势胜率最大的下标
            for(int i=0;i<3;i++){
                if(jia[i]>jia[maxjia]) maxjia = i;
                if(yi[i]>yi[maxyi]) maxyi = i;
            }
            System.out.println(shou[maxjia]+" "+shou[maxyi]);



        }
    }
}