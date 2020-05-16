package util;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import exception.SystemException;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *  单例模式：双重校验锁（保障多线程安全）
 *  面试考点：
 *  1.编码   （一定写的是双重校验锁）
 *  2.谈谈单例/单例的实现方式：
 *   多种实现方式都谈谈：
 *        非线程安全：饿汉模式，懒汉模式
 *        线程安全：双重校验锁，静态内部类，匿名内部类
 *  3.线程安全的单例模式，把代码表达出来（说出重点，为什么）
 *        只需说出代码：
 *        （1）DCL（双重校验锁）
 *        （2）两次null判断：第一次保证效率，第二次保证是同一个对象
 *        （3）中间使用synchronized加锁：保证对象赋值操作的原子性
 *        （4）共享变量使用volatile修饰，禁止指令重排序（再具体说细节）。
 *  4.双重校验锁内部的细节：
 *          两次判断，一次加锁，变量使用volatile，（为什么这样使用）
 */

public class DBUtil {
    private static final String URL ="jdbc:mysql://localhost:3306/blogdemo";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    private static  volatile DataSource  DS;



    private static DataSource getDataSource(){
        if(DS == null){
            synchronized (DBUtil.class){
                if(DS == null){
                    DS = new MysqlDataSource();
                    ((MysqlDataSource) DS).setUrl(URL);
                    ((MysqlDataSource) DS).setUser(USERNAME);
                    ((MysqlDataSource) DS).setPassword(PASSWORD);

                }
            }
        }
        return DS;
    }

    public static Connection getConnection(){
        try {
            return getDataSource().getConnection();
        } catch (SQLException e) {
            throw  new SystemException("000","获取数据库连接异常",e);
        }
    }

    //插入/修改/删除不需要释放ResultSet对象
    public static void close(Connection c, Statement s){
        close(c,s,null);
    }

    //释放资源操作：数据库服务请求/响应也是基于网络数据传输的，
    // 也就是网络IO在使用完之后需要释放资源
    public static void close(Connection c, Statement s, ResultSet r){

        try {
            if(c != null){
                c.close();
            }
            if(s != null){
                s.close();
            }
            if(r != null){
                r.close();
            }
        } catch (SQLException e) {
            throw new SystemException("000","释放数据库资源失败",e);
        }

    }


}
