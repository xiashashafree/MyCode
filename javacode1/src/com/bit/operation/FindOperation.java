package com.bit.operation;
import com.bit.book.BookList;

import java.sql.SQLOutput;

public class FindOperation implements IOperation{
    @Override
    public void work(BookList booklist) {
        System.out.println("请输入你要查找的书籍：");
        String name=scanner.next();
        int i = 0;
        for (; i < booklist.getSize(); i++) {
            if(booklist.getBook(i).name.equals(name)){
                System.out.println(booklist.getBook(i).toString());
                break;
            }
        }
        if(i>=booklist.getSize()){
            System.out.println("无此书籍");

        }

    }
}
