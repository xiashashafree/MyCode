package Servlet;

import model.Article;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@WebServlet("/articleList")
public class articleListServlet extends AbstractBaseServlet {



    @Override
    public Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        return testData();
    }

    //    测试数据
    public static List<Article> testData(){
        return null;
    }
}
