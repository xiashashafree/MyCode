package lesson1;

public class Practice {
    /**
     * 单例模式
     */
    static volatile Practice p = null;

    private Practice(){

    }

    public Practice getInstance(){
        if(p == null){
            synchronized (Practice.class){
                if( p == null){
                    p = new Practice();
                }
                return p;
            }
        }
        return p;
    }

}
