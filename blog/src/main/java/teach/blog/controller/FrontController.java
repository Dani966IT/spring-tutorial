package teach.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import teach.blog.service.BlogService;

@Controller
@RequestMapping("/")
public class FrontController {

    @Autowired
    private BlogService blogService;

    @RequestMapping
    public String hello(ModelMap model) {
        model.addAttribute("entries", blogService.getEntries());
        return "front";
    }

}
