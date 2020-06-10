package free.controller;

import free.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;

@Controller
public class LoginController {
    @RequestMapping(value="/login")
    public String login(Integer i){
        if(i == 1){
            return "redirect:/index.html";
        }else{
            return "forward:/index.html";
        }

    }

    @RequestMapping(value="/login1",method = RequestMethod.POST)
    @ResponseBody
    public Object login2(@RequestParam String username,String password){
        User user = new User();
        user.setUsername("ooo");
        user.setPassword("111");
        user.setBirthday(new Date());
        return user;
    }
    @RequestMapping(value="/login2",method = RequestMethod.POST)
    @ResponseBody
    public Object login3(User user){
        User user1 = new User();
        user1.setUsername(user.getUsername());
        user1.setPassword(user.getPassword());
        user1.setBirthday(user.getBirthday());
        return user1;
    }
    @RequestMapping(value="/login4",method = RequestMethod.POST)
    @ResponseBody
    public Object login4(@RequestBody  User user){
        System.out.println(user);

//        user.setUsername("小龙虾");
//        user.setPassword("123");
//        user.setBrithday(new Date());
        return user;
    }
    @RequestMapping(value="/login5",method = RequestMethod.POST)
    @ResponseBody
    public Object login5(HttpServletRequest request, HttpServletResponse response,
                         User u){

        if("abc".equals(u.getUsername()) && "123".equals(u.getPassword())) {
            HttpSession session = request.getSession(false);
            session.setAttribute("user",u);
            User user = new User();
            user.setUsername("小龙虾");
            user.setPassword("123");
            user.setBirthday(new Date());
            return user;
        }

        return new RuntimeException("登录不成功");


    }
}
