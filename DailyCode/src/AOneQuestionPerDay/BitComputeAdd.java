package AOneQuestionPerDay;

public class BitComputeAdd {


    /***
     * 求1+2+3+....+n的和
     */
    int ret = 0;
    public int Sum_Solution(int n) {

        boolean x = (n>1) && (Sum_Solution(n-1)>0);
        ret+=n;
        return ret;
    }

    /***
     * 求两数之和
     * @param A
     * @param B
     * @return
     */
        public static  int addAB(int A, int B) {
            int temp = 0;

            while(B!=0){
                temp = A^B;//异或表示相加，但不计进位
                B = (A&B)<<1;//计算进位
                A=temp;
            }
            return A;
        }

    public static void main(String[] args) {
        System.out.println(addAB(-1,2));
    }

}
