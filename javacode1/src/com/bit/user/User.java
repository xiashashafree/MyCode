package com.bit.user;
import com.bit.book.*;
import com.bit.operation.IOperation;

public abstract class User {
    public String name;
    protected IOperation[] operations;

    public abstract int menu();
    public void doOperation(int choice,BookList booklist){
        this.operations[choice].work(booklist);
    }
}
