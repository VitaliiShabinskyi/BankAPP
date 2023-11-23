package world.weblucky.bankapp.controller.views;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class SiteController {

    @GetMapping
    public String getHomePage(Model model) {
        model.addAttribute("title", "Welcome to LuckyBank APP");

        return "index";
    }
}
