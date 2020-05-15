package Algorithm;

public class MatrixNthPower {

    public static int[][] matrixPower(int[][] m,int p){
        int[][] res=new int[m.length][m[0].length];
        for (int i = 0; i < res.length; i++) {
            res[i][i] = 1;
        }


        int[][] temp = m;
        for(;p != 0;p>>=1){
            if((p&1) != 0){
                res = muliMatrix(res,temp);
            }
            temp = muliMatrix(temp,temp);
        }
        return res;
    }

    public static int[][] muliMatrix(int[][] m1,int[][] m2){
        int[][] res = new int[m1.length][m2[0].length];
        for (int i = 0; i < m2[0].length; i++) {
            for (int j = 0; j < m1.length; j++) {
                for (int k = 0; k <m2.length ; k++) {
                    res[i][j]+=m1[i][k]*m2[k][j];
                }
            }
        }
        return res;
    }
}
