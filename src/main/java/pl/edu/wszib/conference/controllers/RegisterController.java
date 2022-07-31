package pl.edu.wszib.conference.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.edu.wszib.conference.entities.RegisteredAttendeeEntity;
import pl.edu.wszib.conference.services.RegisterService;

import javax.validation.Valid;

@Controller
public class RegisterController {

    @Value("${app.title.register}")
    private String title;

    @Autowired
    private final RegisterService registerService;

    public RegisterController(RegisterService registerService) {
        this.registerService = registerService;
    }

    @GetMapping("/register")
    public String showRegisterPage(
            @ModelAttribute("newAttendee") RegisteredAttendeeEntity newAttendeeModel,
            Model model
 ) {
        model.addAttribute("title", title);
        return "register";
    }

    @PostMapping("/register")
    public String processRegistration(
            @ModelAttribute("newAttendee") @Valid RegisteredAttendeeEntity newAttendeeEntity,
            BindingResult result) {

        if (result.hasErrors()) {
            return "register";
        }
        registerService.create(newAttendeeEntity);
        return "redirect:/completed";
    }
}
