package com.bit.operation;
import com.bit.book.*;
public class AddOperation implements IOperation {
    @Override
    public void work(BookList booklist) {
        System.out.println("添加书籍");
        System.out.println("请输入图书的名字：");
        String name=scanner.next();
        System.out.println("请输入图书的作者");
        String author=scanner.next();
        System.out.println("请输入图书的价格");
        int price=scanner.nextInt();
        System.out.println("请输入图书的类型");
        String type=scanner.next();
        Book book=new Book(name,author,price,type);
        int cursize=booklist.getSize();
        booklist.setBooks(cursize,book);
        booklist.setSize(cursize+1);
        System.out.println("添加书籍成功");

    }
}
