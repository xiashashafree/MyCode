package free.controller;

import free.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Controller
@RequestMapping("/1")
public class LoginController {
    @RequestMapping(value="/login")
    public String login(){
//        if(i == 1){
//            return "redirect:/index.html";
//        }else{
//            return "forward:/index.html";
//        }
    return "/login.html";
    }


    @RequestMapping(value="/login2",method = RequestMethod.POST)
    @ResponseBody
    public Object login2(@RequestParam String username,String password,String password2){
        User user = new User();
        System.out.println(username+password+password2);
        user.setUsername("光辉女郎");
        user.setPassword("123");
        user.setBirthday(new Date());
        return user;
    }
    @RequestMapping(value="/login3",method = RequestMethod.POST)
    @ResponseBody
    //接受fromdate和xxx-from-encdoing格式请求数据
    public Object login3(User user){
        User user1 = new User();
        System.out.println(user);
        System.out.println(user);
        user1.setUsername("光辉女郎");
        user1.setPassword("123");
        user1.setBirthday(new Date());
        return user1;
    }
    @RequestMapping(value="/login4",method = RequestMethod.POST)
    @ResponseBody
    //接受json格式的请求数据
    public Object login4(@RequestBody User u){
        System.out.println(u);
        User user = new User();
        user.setUsername("小龙虾");
        user.setPassword("123");
        user.setBirthday(new Date());
        return user;
    }
//    @RequestMapping(value="/login5",method = RequestMethod.POST)
//    @ResponseBody
//    public Object login5(HttpServletRequest request, HttpServletResponse response,
//                         User u){
//
//        if("abc".equals(u.getUsername()) && "123".equals(u.getPassword())) {
//            HttpSession session = request.getSession(false);
//            session.setAttribute("user",u);
//            User user = new User();
//            user.setUsername("小龙虾");
//            user.setPassword("123");
//            user.setBirthday(new Date());
//            return user;
//        }
//
//        return new RuntimeException("登录不成功");
//
//
//    }
}
