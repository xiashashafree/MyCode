package util;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;

/**
 * 单例模式多线程安全：静态内部类模式+枚举类（JVM类加载时只加载一次，并且保证线程安全）
 */
public class DemoSingleton {
    //多线程环境下调用DemoSingleton.getDataSource()也是安全的
    //JVM在类加载的时候，类只加载一次，并且是线程安全的（只能一个线程加载）
    public static DataSource getDataSource(){
        return Holder.getDataSource();
    }

    private static class Holder{
        private static final DataSource DATA_SOURCE = new MysqlDataSource();

        static {//类加载时发生
            //初始化  只有一次 且只能一个线程
        }

        public static DataSource getDataSource(){
            return DATA_SOURCE;
        }
    }
}
