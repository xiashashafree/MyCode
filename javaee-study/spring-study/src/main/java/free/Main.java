package free;

import free.model.Duck;
import free.model.DuckShop;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new
                ClassPathXmlApplicationContext("applications.xml");

        //从容器中获取bean对象
        Duck duck1 = (Duck) context.getBean("duck1");
        System.out.println(duck1);
        Duck duck2 = (Duck) context.getBean("duck2");
        System.out.println(duck2);
        DuckShop shop = (DuckShop) context.getBean("duckShop");
        System.out.println(shop);
    }
}
