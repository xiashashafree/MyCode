package com.bit.operation;
import com.bit.book.BookList;
public class ReturnOperation implements IOperation{
    @Override
    public void work(BookList booklist) {

        System.out.println("请输入你要归还的书籍");
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
            booklist.getBook(i).isBorrowed=false;
            System.out.println("成功归还此书");
        }else{
            System.out.println(booklist.getBook(i).isBorrowed);
            System.out.println("还书失败");

        }
    }
}
