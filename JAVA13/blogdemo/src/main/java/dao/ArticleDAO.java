package dao;

import exception.SystemException;
import model.Article;
import util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//JDBC数据库sql操作
public class ArticleDAO {
    //显示文章列表
    public static List<Article> list() {
        Connection c = DBUtil.getConnection();
        PreparedStatement p = null;
        ResultSet r = null;
        String sql ="select id,title,content,user_id,create_time from article";
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
            }
            return articles;

        } catch (SQLException e) {
            throw new SystemException("000","jdbc操作sql出错",e);
        }finally {
            DBUtil.close(c,p,r);
        }


    }
}
