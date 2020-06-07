package free.model;

public class DuckFactory {

    public static Duck create(){
        Duck d = new Duck();
        d.setAge(22);
        d.setName("oo");
        return d;

    }
}
