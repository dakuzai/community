package life.dakuzai.community.community.controller;/**
 * Created by admin on 2019/9/12 15:42
 */

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *@ClassName HelloController
 *@Author admin
 *@Date 2019/9/12 15:42
 **/
@Controller
public class IndexController {

    @GetMapping("/")
public String index(){
        return "index";
    }



}
