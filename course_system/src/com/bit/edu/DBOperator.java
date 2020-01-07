package com.bit.edu;

import com.bit.data.Student;
import com.bit.data.Take;
import com.bit.data.Teacher;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.*;

public class DBOperator {

    private final static String URL="jdbc:mysql://localhost/course_system";
    private final static String user="root";
    private final static String password="root";

    private static DataSource getDataSource(){
        MysqlDataSource ds=new MysqlDataSource();
        ds.setURL(URL);
        ds.setUser(user);
        ds.setPassword(password);
        return ds;
    }
    //1.插入学生表
    public static void insertStudent(Student stu){
        Connection con=null;
        PreparedStatement sta=null;
        try {
            con=getDataSource().getConnection();
            String sql="insert into student(sn,name,classno) values(?,?,?)";
            sta=con.prepareStatement(sql);
            sta.setInt(1,stu.getSn());
            sta.setString(2,stu.getName());

            sta.setInt(3,stu.getClassid());
            sta.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            try {
                if(sta!=null){
                    sta.close();
                }
                if(con!=null){
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


    }
    //2.查询学生表
    public static Student selectStudent(int sn){
        Student stu=new Student();
        Connection con=null;
        PreparedStatement sta=null;
        ResultSet rs=null;

        try {
            con=getDataSource().getConnection();
            String sql="select * from student where sn=?";
            sta=con.prepareStatement(sql);
            sta.setInt(1,sn);
            rs=sta.executeQuery();
            while(rs.next()){
                int sno=rs.getInt(1);
                stu.setSn(sno);
                String name=rs.getString(2);
                stu.setName(name);
                int cno=rs.getInt(3);
                stu.setClassid(cno);
                //System.out.println("学号："+sno+"     姓名："+name+"     班级id："+cno);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            try {
                if(sta!=null){
                    sta.close();
                }
                if(con!=null){
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return stu;
    }

    public static int selectStudentCount(){

        Connection con=null;
        PreparedStatement sta=null;
        ResultSet rs=null;

        int count=0;
        try {
            con=getDataSource().getConnection();
            String sql="select count(sn) as count_s from student";
            sta=con.prepareStatement(sql);
            //sta.setInt(1,sn);
            rs=sta.executeQuery();
            while(rs.next()){
               count=rs.getInt("count_s");
//                stu.setSn(sno);
//                String name=rs.getString(2);
//                stu.setName(name);
//                int cno=rs.getInt(3);
//                stu.setClassid(cno);
                //System.out.println("学号："+sno+"     姓名："+name+"     班级id："+cno);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            try {
                if(sta!=null){
                    sta.close();
                }
                if(con!=null){
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return count;
    }

    //3.插入班级表

    //4.查询班级表


    //5.插入课程表
    //6.查询课程表


    //7.插入教师表
    public static void insertTeacher(Teacher t){

    }
    //8.查询教师表
    public static void selectTeacher(int tno){

    }


    //9.插入take表
    //10.查询take表

    public static Take selectScore(int score){
       Take t=new Take();
        Connection con=null;
        PreparedStatement sta=null;
        ResultSet rs=null;

        try {
            con=getDataSource().getConnection();
            String sql="select count(score),score from take group by score having score>?";
            sta=con.prepareStatement(sql);
            sta.setInt(1,score);
            rs=sta.executeQuery();
            while(rs.next()){
                t.setCount(rs.getInt(1));
                t.setScore(rs.getInt(2));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            try {
                if(sta!=null){
                    sta.close();
                }
                if(con!=null){
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return t;
    }

    //11.插入teach表
    //12.查询teach


    public static void main(String[] args) {
        Student stu=new Student();
        stu.setSn(2020);
        stu.setName("DADA");
        stu.setClassid(1);

      //insertStudent(stu);
        Student stu1=selectStudent(2019);
        System.out.println(stu1);
        System.out.println(selectStudentCount());
        Take t=selectScore(0);
        System.out.println(t);
    }
}
