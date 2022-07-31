package pl.edu.wszib.conference.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @Value("${app.title.main}")
    private String title;

    @GetMapping("/main")
    public String showMainPage(Model model) {
        model.addAttribute("title", title);
        return "main";
    }

    @GetMapping("/")
    String showMain() {
        return "redirect:main";
    }
}
