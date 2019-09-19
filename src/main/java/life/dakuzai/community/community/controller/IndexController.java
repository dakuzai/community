package life.dakuzai.community.community.controller;/**
 * Created by admin on 2019/9/12 15:42
 */

import life.dakuzai.community.community.mapper.UserMapper;
import life.dakuzai.community.community.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 *@ClassName HelloController
 *@Author admin
 *@Date 2019/9/12 15:42
 **/
@Controller
public class IndexController {

    @Autowired
    private UserMapper userMapper;
    @GetMapping("/")
public String index(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if(cookie.getName().equals("token")){
                //获得token
                String token = cookie.getValue();
                User user = userMapper.findByToken(token);
                if(user != null){
                    request.getSession().setAttribute("user",user);
                }
                break;
            }
        }
        return "index";
    }
}
