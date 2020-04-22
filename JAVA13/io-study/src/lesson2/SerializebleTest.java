package lesson2;

import java.io.*;

//对象的序列化与反序列化
public class SerializebleTest {


    public static void main(String[] args) throws Exception{
        Person p= new SerializebleTest.Person();
        ByteArrayOutputStream bs=new ByteArrayOutputStream();

        ObjectOutputStream oos=new ObjectOutputStream(
                new FileOutputStream("E:\\JAVA13\\io-study\\reso\\info1"));
        oos.writeObject(p);
        ObjectInputStream ios=new ObjectInputStream(
                new FileInputStream("E:\\JAVA13\\io-study\\reso\\info1"));
        Person pp=(Person)ios.readObject();
        System.out.println(pp);
    }

    private static class Person implements Serializable {
        private String name;
        private Integer age;
    }
}
