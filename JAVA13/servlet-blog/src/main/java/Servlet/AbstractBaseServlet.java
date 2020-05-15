package Servlet;

import Util.JSONUtil;
import model.Result;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

public abstract class AbstractBaseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json; charset=UTF-8");
        Result result = new Result();
        try{
            //正确返回业务数据
            Object data = process(req,resp);
            result.setSuccess(true);
            result.setData(data);
        }catch (Exception e){
            //捕获到异常，需要设置前端需要的错误信息和堆栈信息
            result.setMessage(e.getMessage());
            StringWriter sw = new StringWriter();
            PrintWriter epw = new PrintWriter(sw);

            e.printStackTrace(epw);
            result.setStackTrace(sw.toString());
        }

        PrintWriter pw = resp.getWriter();
        pw.println(JSONUtil.serialize(result));

        pw.flush();

    }

    public abstract Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception;
}
