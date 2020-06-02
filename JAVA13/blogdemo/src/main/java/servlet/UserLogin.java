package servlet;

import exception.SystemException;
import model.Article;
import model.UseLoginClass;
import util.DBUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet("/login")
public class UserLogin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        UseLoginClass user = new UseLoginClass();
        user.setName(username);
        user.setPassword(password);
        Connection c = DBUtil.getConnection();
        PreparedStatement p = null;
        ResultSet r = null;
        PrintWriter pw = resp.getWriter();
//        String sql ="select id,title,content,user_id,create_time from article where user_id=2";
        String sql="select id,title,content,user_id,create_time from article where user_id=" +
                "(select id from user where name = 'stu')";
        try {
            List<Article> articles = new ArrayList<>();
            p = c.prepareStatement(sql);
            r = p.executeQuery();
            while(r.next()){
                Article article = new Article();
                article.setId(r.getInt("id"));
                article.setTitle(r.getString("title"));
                article.setContent(r.getString("content"));
                article.setUserId(r.getInt("user_id"));
                article.setCreateTime(new Date(r.getTimestamp("create_time").getTime()));
                articles.add(article);
                pw.println("<p>"+article.getTitle()+"</p>");
                pw.println("<p>"+article.getContent()+"</p>");


            }
            pw.flush();


        } catch (SQLException e) {
            throw new SystemException("001","jdbc查询文章列表出错",e);
        }finally {
            DBUtil.close(c,p,r);
        }
    }

}
