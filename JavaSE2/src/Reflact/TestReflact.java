package Reflact;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class TestReflact {
    public static void test3(){
        try {
            //1.获取字节码文件对象
            Class<?> stuClass = Class.forName("Student");

            //获取构造器
            Constructor<?> constructor = stuClass.getDeclaredConstructor(String.class) ;

            //3.实例化对象
            //如果构造器是private，则不能直接用来实例化对象

            constructor.setAccessible(true);//该构造器的访问权限设置为public

            Student s = (Student)constructor.newInstance("UU");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //反射属性
    public static void test4(){

        try {
            //1.获取字节码文件对象
            Class<?> stuClass = Class.forName("Student");

            //获取构造器
            Constructor<?> constructor = stuClass.getDeclaredConstructor(String.class) ;

            //3.实例化对象
            //如果构造器是private，则不能直接用来实例化对象

            constructor.setAccessible(true);//该构造器的访问权限设置为public

            Student s = (Student)constructor.newInstance("UU");

            //反射Student属性
            Field[] fields = stuClass.getFields();//获取所有公有属性
            System.out.println(fields.length);
            Field field = stuClass.getField("name");

            Field[] field1 = stuClass.getDeclaredFields();
            System.out.println(field1.length);
            Field field2 = stuClass.getDeclaredField("name");

            field2.setAccessible(true);//权限修改为public


            System.out.println(field);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
