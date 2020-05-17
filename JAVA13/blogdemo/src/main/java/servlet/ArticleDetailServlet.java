package servlet;

import dao.ArticleDAO;
import exception.BusinessException;
import exception.ClientException;
import model.Article;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/articleDetail")
public class ArticleDetailServlet extends AbstractBaseServlet {

    @Override
    public Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {

        //获取请求数据中的文章id
        String id = req.getParameter("id");
        Integer articleId;
        try{
            articleId= Integer.parseInt(id);
            //现在是测试代码，以后从数据库中获取
        }catch(Exception e){//捕获到异常，需要设置前端
            throw new ClientException("001","请求参数错误[id="+id+"]");
        }
        Article article  = ArticleDAO.query(articleId);
        if(article == null){
            throw new BusinessException("002","无法查找到文章 id="+articleId);
        }
        return article;

    }

//    public static Article testData(){
//        Article a1 = new Article();
//        a1.setId(1);
//        a1.setTitle("好意交换");
//        a1.setContent("呼和佳地大吃二回复");
//        a1.setUserId(1);
//        a1.setCreateTime(new Date());
//        return a1;
//    }
}
