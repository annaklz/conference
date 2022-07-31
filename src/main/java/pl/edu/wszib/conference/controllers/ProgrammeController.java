package pl.edu.wszib.conference.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProgrammeController {

    @Value("${app.title.programme}")
    private String title;

    @GetMapping("/programme")
    public String showProgrammePage(Model model) {
        model.addAttribute("title", title);
        return "programme";
    }
}
