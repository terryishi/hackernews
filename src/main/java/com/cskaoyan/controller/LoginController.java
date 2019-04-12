package com.cskaoyan.controller;
import com.cskaoyan.bean.User;
import com.cskaoyan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpSession;
import java.util.HashMap;

@Controller
public class LoginController {


    @Autowired
    UserService userService;

    @RequestMapping("/login")
    @ResponseBody
    public HashMap<String, Object> loginPage (String username, String password, HttpSession session){

        HashMap<String, Object> result = new HashMap<>();
        User user = userService.findByUserName(username);
        if (user !=null) {
            if (user.getPassword().equals(password)) {
                result.put("code", 0);
                session.setAttribute("user", user);
            } else {
                result.put("code", 1);
                result.put("msgpwd", "密码错误");
            }
        }else {
            result.put("code", 1);
            result.put("msgname","用户名不存在");
        }

        return result;
    }

    @RequestMapping("/logout")
    public String logoutPage (HttpSession session){

        session.removeAttribute("user");

        return "redirect:/";
    }

    @RequestMapping("/reg/")
    @ResponseBody
    public HashMap<String, Object> regPage (String username, String password, HttpSession session){

        User user = new User();
        user.setName(username);
        user.setPassword(password);
        HashMap<String, Object> result = new HashMap<>();
        User user1 = userService.findByUserName(username);
        if (username != null){
            if ( user1 == null){
                int i = userService.insertUser(username, password);
                session.setAttribute("user", user);
                result.put("code",0);
            }else {
                result.put("msgname","用户名已被占用");
                result.put("code",1);
            }
        }else {
            result.put("code",1);
            result.put("msgname","用户名为空");
        }
        return result;
    }
}
