package Algorithm.DFS;

import com.sun.org.apache.bcel.internal.generic.RETURN;

class P implements Cloneable{
    int num = 0;
    String name = "朱一龙";
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
    public String getName(){
        return name;
    }
    public static void yy(){
        System.out.println("j");
    }
}
class O extends P{

    public static void yy(){
        System.out.println();
    }
}
public class IslandNumber {
    public static void main(String[] args) throws CloneNotSupportedException {
        P p = new P();
        P p1 =(P)p.clone();
        System.out.println(p.getName() == p1.getName().intern());

    }

}
