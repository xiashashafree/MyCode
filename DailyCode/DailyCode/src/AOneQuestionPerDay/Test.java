package AOneQuestionPerDay;

import java.lang.reflect.Method;

public class Test {
    public static void main(String[] args) {
       // System.out.println(new B().getValue() );
//        try {
//            Class c=Class.forName(args[0]);
//            Method m[] = c.getDeclaredMethods();
//            if(m == null){
//                System.out.println("ooo");
//            }
////            for (int i = 0; i < m.length; i++) {
////                System.out.println(m[i]);
////            }
//        } catch (Throwable e) {
//            e.printStackTrace();
//        }
        Integer i01 = 59;
        int i02=59;
        Integer i03=Integer.valueOf(59);
        Integer i04 = new Integer(59);
        System.out.println(i03 == i04);
        System.out.println(i01 == i03);
        String s = "ppp";
    }

    static class A{
        protected  int value;
        public A(int v){
            setValue(v);
        }
        public void setValue(int value){
            this.value = value;
        }
        public int getValue(){
            try{
                value++;
                return value;
            }catch(Exception e){
                System.out.println(e.toString());
            }finally {
                this.setValue(value);
                System.out.println(value);
            }
            return value;
        }
    }
    static class B extends  A{
        public B(){
            super(5);
            setValue(getValue()-3);
        }
        public void setValue(int value){
            super.setValue(value);
        }
    }
}
