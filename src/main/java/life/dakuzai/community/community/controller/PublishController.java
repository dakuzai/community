package life.dakuzai.community.community.controller;

import life.dakuzai.community.community.dto.GithubUser;
import life.dakuzai.community.community.mapper.QueationMapper;
import life.dakuzai.community.community.mapper.UserMapper;
import life.dakuzai.community.community.model.Question;
import life.dakuzai.community.community.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName PublishController
 * @Author admin
 * @Date 2019/9/19 16:24
 **/
@Controller
public class PublishController {

    @Autowired
    private QueationMapper queationMapper;

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/publish")
    public String publish(){

        return "publish";
    }

    @RequestMapping("/publish")
    public String doPublish(@RequestParam("title") String title,
                            @RequestParam("description") String description,
                            @RequestParam("tag") String tag,
                            HttpServletRequest request,
                            Model model){
        User user = null;
        Cookie[] cookies = request.getCookies();
        if(cookies != null && cookies.length != 0){
            for (Cookie cookie : cookies) {
                if(cookie.getName().equals("token")){
                    //获得token
                    String token = cookie.getValue();
                    user = userMapper.findByToken(token);
                    if(user != null){
                        request.getSession().setAttribute("user",user);
                    }
                    break;
                }
            }
        }

        if (user == null){
            model.addAttribute("erro","用户未登录");
        }

        Question question = new Question();
        question.setDescription(description);
        question.setTitle(title);
        question.setTags(tag);
        queationMapper.create(question);


        return "publish";
    }
}
