package servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/articleDelete")
public class ArticleDeleteServlet extends  AbstractBaseServlet {


    @Override
    public Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {

        //ids = 1,2,3
        String idsString = req.getParameter("ids");
        int[] ids = parseIds(idsString);

        //把ids传到数据库中 删除文章
        return null;

    }

    public static int[] parseIds(String idsString){
        String[] idsArray = idsString.split(",");
        int[] ids = new int[idsArray.length];
        for (int i=0;i<ids.length;i++) {
            ids[i] = Integer.parseInt(idsArray[i]);
        }
        return ids;
    }
}
