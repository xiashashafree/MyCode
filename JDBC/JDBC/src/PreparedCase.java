import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.*;

class student{
   String name;
   int sn;
   double height;

     public void setName(String name) {
         this.name = name;
     }

     public void setSn(int sn) {
         this.sn = sn;
     }

     public void setHeight(double height) {
         this.height = height;
     }

     public String getName() {
         return name;
     }

     public int getSn() {
         return sn;
     }

     public double getHeight() {
         return height;
     }

 }
public class PreparedCase {
    private final static String URL="jdbc:mysql://localhost/ebook";
    private final static String user="root";
    private final static String password="root";

    public static DataSource getDataSource(){
        MysqlDataSource ds=new MysqlDataSource();
        ds.setURL(URL);
        ds.setUser(user);
        ds.setPassword(password);
        return ds;
    }
    public static void createTbale(){
        DataSource data=getDataSource();
        Connection con=null;
            PreparedStatement sta=null;
        try {
            con=data.getConnection();
            String sql="create table student("+"name varchar(20) not null,"
                    +"sn int primary key,"
                    +"height double(5,2));";
            sta=con.prepareStatement(sql);
            sta.execute(sql);
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
    public static void insertTable(){
        DataSource data=getDataSource();
        Connection con=null;
        PreparedStatement sta=null;
        try {
            con=data.getConnection();
            String sql="insert into borrow_info values(?,?,?,?,?);";
            sta=con.prepareStatement(sql);
            sta.setInt(1,19);
            sta.setInt(2,10);
            sta.setInt(3,3);
            sta.setString(4,"2019-09-25 17:50:00");
            sta.setString(5,"2019-10-25 17:50:00");
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
    public static void select(String s){
    DataSource ds=getDataSource();
    Connection con=null;
    PreparedStatement sta=null;
    ResultSet rs=null;
        try {
            con=ds.getConnection();
//            查询计算机分类下的图书借阅信息
            String sql="select book.category_id,category.name,book.id,book.name from( book inner join category on(book.category_id=category.id) inner join borrow_info on(book.id=borrow_info.book_id)) where category.name=?;";
//String sql="select book.name ,book.id from( book inner join category on(book.category_id=category.id) inner join borrow_info on(book.id=borrow_info.book_id)) where category.name=?";
       //     String sql="select name,id from book";
            sta=con.prepareStatement(sql);
            sta.setString(1,s);
            rs=sta.executeQuery();
            while(rs.next()){
                //System.out.println(rs.next());
                Integer cateid=rs.getInt(1);
                //System.out.println(cateid);
                String cname=rs.getString(2);
                Integer bid=rs.getInt(3);
                String bname=rs.getString(4);

                //System.out.println(bname+" "+bid);
                System.out.println("分类编号:"+cateid+"   图书类别:"+cname+"    图书编号:"+bid+"    书名："+bname);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static void update(){
        DataSource ds=getDataSource();
        Connection con;
        PreparedStatement sta;
        ResultSet rs;
        try {
            con=ds.getConnection();
//            查询计算机分类下的图书借阅信息
          //  String sql="select book.category_id,category.name,book.id,book.name from( book inner join category on(book.category_id=category.id) inner join borrow_info on(book.id=borrow_info.book_id)) where category.name=?;";
            String sql="update book set price=2 where name=?";
            sta=con.prepareStatement(sql);
            String s="xiyouji";
            sta.setString(1,s);
            int i=sta.executeUpdate();
           if(i>0){
                System.out.println("更新成功");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        //createTbale();
       // insertTable();
       select("jisuanji");
       update();
    }
}
