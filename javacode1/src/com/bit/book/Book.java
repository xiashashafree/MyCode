package com.bit.book;

public class Book {

    public String name;
    public String author;
    public int price;
    public String type;
    public boolean isBorrowed;

    public Book(String name, String author, int price, String type) {
        this.name = name;
        this.author = author;
        this.price = price;
        this.type = type;

    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", typr='" + type + '\'' +
                ((isBorrowed==true) ? ",已经借出":"，未借出")+
               // ", isBorrowed=" + isBorrowed +
                '}';
    }
}
