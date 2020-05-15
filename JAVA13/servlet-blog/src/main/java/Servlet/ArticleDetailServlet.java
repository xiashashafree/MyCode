package Servlet;

import exception.ClientException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ArticleDetailServlet extends AbstractBaseServlet {
    @Override
    public Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String id = req.getParameter("id");
        try{
            Integer articleId = Integer.parseInt(id);

        }catch (Exception e){
            throw new ClientException("001","参数请求错误： id="+id)
        }


        return null;
    }
}
