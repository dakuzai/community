package life.dakuzai.community.community.controller;/**
 * Created by admin on 2019/9/16 14:30
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *@ClassName AuthorizeController
 *@Author admin
 *@Date 2019/9/16 14:30
 **/
@Controller
public class AuthorizeController {
    @GetMapping("/callback")
    public String callback(@RequestParam(name = "code") String code,
                           @RequestParam(name = "state") String state){
        return "index";
    }
}
