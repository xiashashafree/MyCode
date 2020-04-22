package lesson2;

import java.io.File;
import java.util.Arrays;

public class FileTest {
    public static void main(String[] args) {
//        File file1 = new File("E:\\JAVA13\\io-study\\reso");
//        File file2 = new File("E:\\JAVA13\\io-study\\reso1");
//        System.out.println(file1.isDirectory());
//        System.out.println(Arrays.toString(file1.listFiles()));
//        System.out.println( file1.getPath());
//        System.out.println(file2.exists());
//        System.out.println(file2.mkdirs());

        char[] ch=new char[1];
        ch[0]='o';
        ch.toString();
        String s="0";
        s.split("");
        StringBuilder sb = new StringBuilder("a");

        print(sb.append("b"));


    }

    //变量和值（对象）区分开 = 号赋值引用指向
    //传入参数，局部变量是在线程执行方法的时候创建，方法执行完就销毁
    //这些信息是以栈帧保存在栈中，和（线程）执行（方法）有关
    public static void print(StringBuilder sb){
        System.out.println(sb.toString());
    }
}
