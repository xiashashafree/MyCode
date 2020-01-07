import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.*;


public class InsertCase {
    public static DataSource getDataSource(){
        MysqlDataSource ds=new MysqlDataSource();
        ds.setUrl("");
        ds.setUser("");
        ds.setPassword("");
        return ds;
    }
    public static Connection getConnection(){
        Connection connection=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/my_jdbc_db2",
                    "root", "root");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
    public static void createTable() {
        Connection conn = null;
        Statement sta = null;
        try {
            try {
//                Class.forName("com.mysql.jdbc.Driver");
//                conn = DriverManager.getConnection("jdbc:mysql://localhost/my_jdbc_db2", "root", "root");
                conn=getConnection();
                sta = conn.createStatement();
                sta.execute("create table table1(col1 int,col2 varchar(20))");
            }  catch (SQLException e) {
                e.printStackTrace();
            }
        } finally {
            try {
                if (sta != null) {
                    sta.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

//    public static void insertIntoTable() {
//
//        Connection con = null;
//        Statement st = null;
//        ResultSet re=null;
//        try {
//            try {
//                Class.forName("com.mysql.jdbc.Driver");
//                con = DriverManager.getConnection("jdbc:mysql://localhost/my_jdbc_db2", "root", "root");
//                st = con.createStatement();
//                //st.execute("insert into table1 values(1,'hello')");
//                re= st.executeQuery("select * from table1");
//                while(re.next()){
//                    Integer i=
//                            re.getInt("col1");
//                    String s=
//                            re.getString("col2");
//                    System.out.println("col1:"+i+" "+"col2:"+s);
//                }
//            } catch (ClassNotFoundException e) {
//                e.printStackTrace();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        } finally {
//            try {
//                if (st != null) {
//                    st.close();
//                }
//                if (con != null) {
//                    con.close();
//                }
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//    }

    public static void selectTable(){
        Connection con=null;
        Statement sta=null;
        ResultSet re=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
           // con=getDataSource().getConnection();
            con=DriverManager.getConnection("jdbc:mysql://localhost/my_jdbc_db2","root","root");
            sta=con.createStatement();
            re=sta.executeQuery("select * from table1");
            while(re.next()){
                Integer i=re.getInt(1);
                String s=re.getString(2);
                System.out.println("col1:"+i+" "+"col2:"+s);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
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
                if(re!=null){
                    re.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        //createTable();
        // insertIntoTable();
        selectTable();
        DataSource d=new MysqlDataSource();
    }
}
