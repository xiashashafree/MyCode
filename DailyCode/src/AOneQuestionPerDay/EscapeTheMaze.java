package AOneQuestionPerDay;


import java.util.*;
public class EscapeTheMaze {


        static LinkedList<String> path = new LinkedList<>();
        static int pp = 0;
        static int[][] arr;
        static int m;
        static int n;
        static String s;
        static Boolean escape = false;
        private static void ret(int i,int j,int power){
            if ( i<0|| j<0 || i>=n || j>=m || power<0 || arr[i][j] != 1)
            {//走不出去或者此路不通
                return;
            }else{
                //这条路可以走
                arr[i][j] =0; //代表走过了
                path.offer("["+i+","+j+"]");
                if( i==0 && j == m-1 ){//走到了重点
                    if(power >= pp){//如果剩余的能量比上次多，就更新路径
                        pp = power;
                        update();
                    }
                    arr[i][j] = 1;//原路返回
                    path.removeLast();
                    escape = true;
                    return;//继续尝试其他路径
                }
                ret(i-1,j,power-3);
                ret(i,j+1,power-1);

                ret(i+1,j,power);
                ret(i,j-1,power-1);
                //上下左右都走不通,回到上个位置
                arr[i][j] = 1;//将上个位置重新标记为可走的
                path.removeLast();//删去走不通的位置


            }

        }
        private static void update(){
            StringBuilder sb = new StringBuilder();
            for(String s1:path){
                sb.append(s1+",");
            }
            if (sb.length() > 0)
            {
                sb.deleteCharAt(sb.length()-1);
            }
            s = sb.toString();

        }
        public static void main(String[] args){
            Scanner sc = new Scanner(System.in);

            n = sc.nextInt();
            m = sc.nextInt();
            int p = sc.nextInt();
            arr = new int[n][m];
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    arr[i][j] = sc.nextInt();
                }
            }
            sc.nextLine();
            ret(0,0,p);
            if(escape){
                System.out.println(s);
            }else{
                System.out.println("Can not escape!");
            }
        }

}
