package servlet;

import exception.ClientException;
import model.Article;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

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
        if(articleId == 1){
            int i = 11/0;
        }
        return testData();

    }

    public static Article testData(){
        Article a1 = new Article();
        a1.setId(1);
        a1.setTitle("好意交换");
        a1.setContent("呼和佳地大吃二回复");
        a1.setUserId(1);
        a1.setCreateTime(new Date());
        return a1;
    }
}
