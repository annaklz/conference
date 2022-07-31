package pl.edu.wszib.conference.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VenueController {

    @Value("${app.title.venue}")
    private String title;

    @GetMapping("/venue")
    public String showVenuePage(Model model) {
        model.addAttribute("title", title);
        return "venue";
    }
}
