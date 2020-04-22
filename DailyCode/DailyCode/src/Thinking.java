public class Thinking {
    /**斐波那契数列*/
    public int Fibonacci(int n) {
        if(n==0){
            return 0;
        }
        if(n==1 || n==2){
            return 1;
        }
        return Fibonacci(n-1)+Fibonacci(n-2);
    }

    /**数值的整数次方，此种方法有缺陷，在LeetCode上不能通过全部用例*/
    //exponent次方参数可能＞0，或＜0
    public double Power(double base, int exponent) {
        if(base == 0.0){
            return 0.0;
        }
        //浮点数的初始化表示
        double ret=1.0d;
        int exp=(exponent>0)? exponent:-exponent;
        for(int i=0;i<exp;i++){
            ret=ret*base;
        }
        return (exponent>0) ?  ret:(1/ret);
    }
}
