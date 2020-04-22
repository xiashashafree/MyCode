package lesson2;


import jdk.nashorn.internal.runtime.ECMAException;
import org.junit.Test;

import java.io.*;

public class FileOperatorTest {

    @Test
    public void fileRead_1() throws IOException {

        //字节流转换为字符流，需要使用字符字节流转换流
        //转换流可以设置编码：java文件编码格式，文件编码格式
        //InputStreamReader:输入的字节字符转换流   OutputStreamReader:输出的字节字符转换流
        FileInputStream f = null;
        BufferedReader br = null;

        try {
            f = new FileInputStream(new File("E:\\JAVA13\\io-study\\reso\\info"));
            br = new BufferedReader(new InputStreamReader(f));
//        String line;
//        while((line =br.readLine()) != null){
//
//            System.out.println(line);
//        }
            char[] chars = new char[1024];
            int len = 0;

            while ((len = br.read(chars)) != -1) {
                String s = new String(chars, 0, len);
                System.out.println(s);
            }
        } finally {
            if (f != null) {
                f.close();
            }
            if (br != null) {
                br.close();
            }
        }


    }

    @Test
    public void fileRead_2() throws IOException {
        FileInputStream f = new FileInputStream(new File("E:\\JAVA13\\io-study\\reso\\info"));
        //按字节读取
        byte[] bt = new byte[1024];
        int len = 0;
        while ((len = f.read(bt)) != -1) {
            String s = new String(bt, 0, len);
            System.out.println(s);
        }
        f.close();
    }

    @Test
    public void fileWrite_1() throws IOException {
        FileOutputStream f = new FileOutputStream(new File("E:\\JAVA13\\io-study\\reso\\info"));
        //按字节读取
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(f));

        //使用缓冲流，输出时要使用flush刷新缓冲区，
        bw.write("1:哈哈哈哈哈哈哈哈哈哈或或或或\n");
        bw.write("2:还可时间冻结几女诶u是回去\n");
        bw.write("3:hi健康才能和部分可不能说你");
        bw.flush();//缓冲区刷新
        f.close();
    }

    @Test
    public void fileCopy() throws Exception {
        //将一个文件的内容拷贝到另一个文件中
        FileInputStream f = new FileInputStream(new File("E:\\JAVA13\\io-study\\reso\\info"));
        BufferedInputStream bi=new BufferedInputStream(f);
        FileOutputStream fw = new FileOutputStream(new File("E:\\JAVA13\\io-study\\reso\\info2"));
        BufferedOutputStream bo=new BufferedOutputStream(fw);
        byte[] bt = new byte[1024];
        int len = 0;
        while ((len = bi.read(bt)) != -1) {
            bo.write(bt);
            bo.flush();
        }

    }
}
