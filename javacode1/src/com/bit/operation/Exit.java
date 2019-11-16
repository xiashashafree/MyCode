package com.bit.operation;
import com.bit.book.BookList;
public class Exit implements IOperation{
    @Override
    public void work(BookList booklist) {
        System.out.println("bye bye");
        System.exit(0);
    }
}
