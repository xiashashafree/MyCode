package servlet;

import dao.ArticleDAO;
import model.Article;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

//当请求路径为此时，这个Servlet为之服务
@WebServlet("/articleList")
public class ArticleListServlet extends AbstractBaseServlet {

    @Override
    public Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {

        List<Article> articles = ArticleDAO.list();
        return articles;
//        return testData();
    }
    //测试数据
//    public  static List<Article> testData(){
//        List<Article> articles = new ArrayList<>();
//        Article a1 = new Article();
//        a1.setId(1);
//        a1.setTitle("好意交换");
//        a1.setContent("呼和佳地大吃二回复");
//        a1.setUserId(1);
//        a1.setCreateTime(new Date());
//        Article a2 = new Article();
//        a2.setId(2);
//        a2.setTitle("好意交换");
//        a2.setContent("呼和佳地大吃二回复");
//        a2.setUserId(1);
//        a2.setCreateTime(new Date());
//        articles.add(a1);
//        articles.add(a2);
//        return articles;
//
//    }


}
