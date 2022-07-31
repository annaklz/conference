package pl.edu.wszib.conference.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FeesController {

    @Value("${app.title.fees}")
    private String title;

    @GetMapping("/fees")
    public String showFeesPage(Model model) {
        model.addAttribute("title", title);
        return "fees";
    }
}
