package free.config;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Controller中，所有处理客户端请求的方法
 * 抛异常都会进入异常处理逻辑
 */

@ControllerAdvice
public class ExceptionAdvisor {

//    @ExceptionHandler(Exception.class)//Exception.class ->拦截的异常类
//    @ResponseBody//返回json数据格式
//    public Object handle(Exception e){//抛出的异常会传入 e 这个参数
//        Map<String,String> map = new HashMap<>();
//        map.put("error",e.getMessage());
//        StringWriter sw = new StringWriter();
//        PrintWriter pw = new PrintWriter(sw);
//        e.printStackTrace(pw);
//        map.put("stackTrace",sw.toString());
//        return map;
//    }

    @ExceptionHandler(Exception.class)//Exception.class ->拦截的异常类
    public String handle(HttpServletResponse response){
        try {//重定向到error.html
            response.sendRedirect("/error.html");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
