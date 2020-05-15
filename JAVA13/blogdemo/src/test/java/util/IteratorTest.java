package util;

import java.util.ArrayList;
import java.util.List;

public class IteratorTest {

    public static void main(String[] args) {
        //非线程安全的数据结构，内部的迭代器都是一种fail-fast快速失败的迭代器
        //在迭代操作非线程安全的数据结构时，修改数据操作，会导致下一次迭代失败
        //---->多线程对同一个非线程安全的数据结构操作，一个线程遍历，如果另一个线程修改了，下次

        List<Integer> list = new ArrayList<>();
        int len = 10000;
        for (int i = 0; i <len ; i++) {
            list.add(i);
        }

        for (int i: list
             ) {
            if (i == 3) {
                list.remove(i);
            }
            System.out.println(i);
        }

    }
}
