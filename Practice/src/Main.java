import com.mysql.jdbc.Driver;
import java.sql.*;


public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //注册Driver
        Class.forName("com.mysql.jdbc.Driver");
        //获取连接

        String url="jdbc:mysql://127.0.0.1:3306/test?useSSL=false";
        String username="root";
        String password="root";
        Connection con=DriverManager.getConnection(
                url,
                username,
                password);
        //获取执行语句
        Statement sta=con.createStatement();
        String sql="select name from user";
        ResultSet rs=sta.executeQuery(sql);
        while(rs.next()){
            String name=rs.getString(1);
            System.out.println(name);
        }
        //执行语句
        //关闭语句
        sta.close();
        //关闭连接
        con.close();
    }

}
