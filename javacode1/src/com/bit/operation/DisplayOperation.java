package com.bit.operation;
import com.bit.book.BookList;
public class DisplayOperation implements IOperation{
    @Override
    public void work(BookList booklist) {
        for (int i = 0; i <booklist.getSize() ; i++) {
            System.out.println(booklist.getBook(i).toString());
        }
    }
}
