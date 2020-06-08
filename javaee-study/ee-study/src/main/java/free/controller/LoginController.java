package free.controller;

import free.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@Controller
public class LoginController {
    @RequestMapping("/login")
    public String login(){
        return "/login.html";
    }

    @RequestMapping(value="/login1",method = RequestMethod.POST)
    @ResponseBody
    public Object login2(@RequestParam String username,String password){
        User user = new User();
        user.setUsername("ooo");
        user.setPassword("111");
        user.setBrithday(new Date());
        return user;
    }
    @RequestMapping(value="/login2",method = RequestMethod.POST)
    @ResponseBody
    public Object login3(User user){
        User user1 = new User();
        user1.setUsername(user.getUsername());
        user1.setPassword(user.getPassword());
        user1.setBrithday(user.getBrithday());
        return user1;
    }
}
