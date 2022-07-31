package pl.edu.wszib.conference.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CompletedController {

    @Value("${app.title.completed}")
    private String title;

    @GetMapping("/completed")
    public String showCompletedPage(Model model) {
        model.addAttribute("title", title);
        return "completed";
    }

}
