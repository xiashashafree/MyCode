package servlet;

import exception.BaseException;
import model.Result;
import util.JSONUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class AbstractBaseServlet extends HttpServlet {

    private static final ConcurrentHashMap<String,Integer> MAP = new ConcurrentHashMap<>();

    private static final ConcurrentHashMap<String, AtomicInteger> MAP2 = new ConcurrentHashMap<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json; charset=UTF-8");

        //前端约定好的统一返回的json数据格式
        Result result = new Result();
        try{
//            List<Article> articles = testData();
            Object data = process(req,resp);
            result.setSuccess(true);
            result.setData(data);
        }catch (Exception e){//捕获到异常，需要设置前端
            if(e instanceof BaseException){
                BaseException be = (BaseException)e;
                result.setMessage("错误码："+be.getCode()+". 错误信息："+be.getMessage());
            }else{
                result.setMessage("服务器异常：未知的错误");
            }

            StringWriter sw = new StringWriter();
            PrintWriter epw = new PrintWriter(sw);
            e.printStackTrace(epw);
            result.setStackTrace(sw.toString());
        }

        PrintWriter pw = resp.getWriter();
        pw.println(JSONUtil.serialize(result));
        pw.flush();

        System.out.println(req.getScheme());//协议号

//        System.out.println(req.getServletPath());//请求servlet路径：/articleList
//        System.out.println(req.getContextPath());//应用部署路径（上下文路径）/blogDemo：
//        System.out.println(req.getRequestURL());//请求的全路径
//        System.out.println(req.getRequestURI());//contextPath+servlet路径
//        System.out.println(req.getPathInfo());
//        String path = req.getServletPath();
       // Integer count = MAP.get(path);//map.get()是线程安全的

        //方法1：synchronized保证代码的原子性
//        synchronized (MAP){
//            if(count == null){
//                count = 1;
//            }else{
//                count++;
//            }
//            MAP.put(path,count);
//        }

        //方法二，通过AtomicInteger集合ConcurrentHashMap来保证线程安全
        String path = req.getServletPath();
        AtomicInteger count = MAP2.putIfAbsent(path,new AtomicInteger());


    }

    public abstract  Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception;

}
