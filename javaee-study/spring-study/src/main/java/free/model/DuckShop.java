package free.model;

import java.util.List;

public class DuckShop {
    List<Duck>  ducks ;

    public List<Duck> getDucks() {
        return ducks;
    }

    public void setDucks(List<Duck> ducks) {
        this.ducks = ducks;
    }

    @Override
    public String toString() {
        return "DuckShop{" +
                "ducks=" + ducks +
                '}';
    }
}
