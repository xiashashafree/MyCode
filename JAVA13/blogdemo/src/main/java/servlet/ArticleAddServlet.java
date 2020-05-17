package servlet;

import dao.ArticleDAO;
import exception.BusinessException;
import model.Article;
import util.JSONUtil;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;

@WebServlet("/articleAdd")
public class ArticleAddServlet extends AbstractBaseServlet {


    @Override
    public Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {

        //从IO流中获取请求信息
        InputStream is = req.getInputStream();
        //文章新增：title content  useracount
        Article article = JSONUtil.deserialize(is,Article.class);

        System.out.println("*****************\n"+article);
        int num = ArticleDAO.insert(article);
        //http请求Content-type为application/hson，请求体是json字符串，需要反序列化为javaduix
        //需要 检查json字符串的键值必须和java类型中的属性能匹配
        //模拟数据库插入操作
        if(num != 1){
            throw new BusinessException("001","插入文章错误");
        }


        return null;
    }


}
