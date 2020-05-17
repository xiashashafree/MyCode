package servlet;

import dao.ArticleDAO;
import exception.BusinessException;
import model.Article;
import util.JSONUtil;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;

@WebServlet("/articleUpdate")
public class ArticleUpdateServlet extends AbstractBaseServlet{
    @Override
    public Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {

        //文章修改：包含id title content
        //从IO流中获取请求信息
        InputStream is = req.getInputStream();
        Article article = JSONUtil.deserialize(is,Article.class);

        //http请求Content-type为application/hson，请求体是json字符串，需要反序列化为javaduix
        //需要 检查json字符串的键值必须和java类型中的属性能匹配
        //模拟数据库修改操作

        System.out.println("*****************\n"+article);
        int num = ArticleDAO.update(article);

        if(num!= 1){
            throw new BusinessException("004","文章更新出错");
        }
        return null;
    }

}
