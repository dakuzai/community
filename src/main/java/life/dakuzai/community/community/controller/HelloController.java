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
public class HelloController {

    @GetMapping("hello")
    public String hello(@RequestParam(name = "name") String name, Model model){

        model.addAttribute("name",name);

        return "hello";


    }



}
