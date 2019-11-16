package com.bit.operation;
import com.bit.book.*;
public class BorrowOperation implements IOperation{
    @Override
    public void work(BookList booklist) {
        System.out.println("请输入你要借阅的书籍");
       String name=scanner.next();
       int i=0;
        for (; i < booklist.getSize(); i++) {
            if(booklist.getBook(i).name.equals(name)){
                break;
            }
        }
        if(i>=booklist.getSize()){
            System.out.println("无此书籍");
            return;
        }
        if(booklist.getBook(i).isBorrowed){
            System.out.println(booklist.getBook(i).isBorrowed);
            System.out.println("此书已被借出");
        }else{
            booklist.getBook(i).isBorrowed=true;
            System.out.println("成功借阅此书");
        }
    }
}
