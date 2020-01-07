//package com.bit.edu.mysql;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//import java.sql.Statement;
//
//
//public class HelloWorld {
//    public static void main(String[] args) {
//
//        Connection conn = null;
//        Statement sta = null;
//        try {
////            //加载数据库驱动
////            Class.forName("com.mysql.jdbc.Driver");
//
//            //获取连接  url:统一资源定位器
//            try {
//                Class.forName("com.mysql.jdbc.Driver");
//                //协议
//                conn = DriverManager.getConnection("jdbc:mysql://localhost/", "root",
//                        "root");
//                sta = conn.createStatement();
//                sta.execute("create database my_jdbc_db2");
//
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        } catch (ClassNotFoundException e) {
////            e.printStackTrace();
////        } finally {
////            try {
////                if (sta != null) {
////                    sta.close();
////                }
////                if (conn != null) {
////                    conn.close();
////                }
////            } catch (SQLException e) {
////                e.printStackTrace();
////            }
//
//        }
//    }
//}
