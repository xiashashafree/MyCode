package AOneQuestionPerDay;

public class BitComputeAdd {

        public int addAB(int A, int B) {
            int temp = 0;
            int carry = 0;
            while(B!=0){
                temp = A^B;//异或表示相加，但不计进位
                B = (A&B)<<1;//计算进位
                A=temp;
            }
            return A;
        }

}
