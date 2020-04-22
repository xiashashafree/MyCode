package lesson1;

import java.util.Scanner;

public class ScannerTest {


    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        for (int i = 0; i <10 ; i++) {
            //多线程的阻塞也是需要满足一定条件才返回：synchronized,join,wait,sleep
            //1.都是阻塞式方法，造成当前线程阻塞
            //2.满足一定条件才返回：hasNext满足换行符或空格等特殊字符
            //hasNext满足换行特殊字符，next满足换汉符/空格
            //hasNextLine满足换行符
            //hasNextInt读取到不满足Int数值的字符

            //io流中的数据，进行读/写操作只能执行一次

        }
    }





}
