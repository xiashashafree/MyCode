package com.bit.operation;
import com.bit.book.*;

import java.sql.SQLOutput;

public class DelOperation implements IOperation {
    @Override
    public void work(BookList booklist) {
        System.out.println("请输入你要删除的书籍：");
        String name=scanner.next();
        int i = 0;
        for (; i < booklist.getSize(); i++) {
            if(booklist.getBook(i).name.equals(name)){
                break;
            }
        }
        if(i>=booklist.getSize()){
            System.out.println("无此书籍");
            return;
        }
        for(int j=i;j<booklist.getSize()-1;j++){
            Book nextBook=booklist.getBook(j+1);
            booklist.setBooks(j,nextBook);

        }
        booklist.setSize(booklist.getSize()-1);
        System.out.println("删除成功");

    }
}
