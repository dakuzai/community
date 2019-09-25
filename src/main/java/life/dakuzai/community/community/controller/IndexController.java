package life.dakuzai.community.community.controller;/**
 * Created by admin on 2019/9/12 15:42
 */

import life.dakuzai.community.community.dto.QuestionDto;
import life.dakuzai.community.community.mapper.UserMapper;
import life.dakuzai.community.community.model.User;
import life.dakuzai.community.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 *@ClassName HelloController
 *@Author admin
 *@Date 2019/9/12 15:42
 **/
@Controller
public class IndexController {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private QuestionService questionService;

    @GetMapping("/")
public String index(HttpServletRequest request, Model model){
        Cookie[] cookies = request.getCookies();
        if (cookies != null && cookies.length != 0){
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
        }
        List<QuestionDto> questionDtoList = questionService.list();
        model.addAttribute("question",questionDtoList);
        return "index";
    }
}
