package com.bit;
import com.bit.book.BookList;
import com.bit.user.Admin;
import com.bit.user.NormalUser;
import com.bit.user.User;
import com.bit.operation.*;
import java.util.Scanner;

public class Main {
    public static User login( ){

        System.out.println("请输入你的名字：");
        Scanner scanner=new Scanner(System.in);
        String name=scanner.next();
        System.out.println("请输入你的身份（0:普通用户/1：管理员）：");
        int who=scanner.nextInt();
        if(who==1){
           return new Admin(name);
        }else{
           return new NormalUser(name);
        }

    }
    public static void main(String[] args) {
       User user=login();
        BookList booklist=new BookList();
   while(true){
       int choice=user.menu();
       user.doOperation(choice,booklist);





   }
    }

}
