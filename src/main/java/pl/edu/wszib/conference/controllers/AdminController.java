package pl.edu.wszib.conference.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.edu.wszib.conference.entities.RegisteredAttendeeEntity;
import pl.edu.wszib.conference.repositories.RegisteredAttendeesRepository;
import pl.edu.wszib.conference.services.AdminService;

import javax.validation.Valid;
import java.util.List;

@Controller
public class AdminController {

    @Autowired
    private final RegisteredAttendeesRepository registeredAttendeesRepository;
    @Autowired
    private final AdminService adminService;

    public AdminController(RegisteredAttendeesRepository registeredAttendeesRepository, AdminService adminService) {
        this.registeredAttendeesRepository = registeredAttendeesRepository;
        this.adminService = adminService;
    }

    @Value("${app.title.admin}")
    private String title;

    @Value("${app.title.edit-attendee}")
    private String title2;

    @GetMapping("/admin")
    public String showAdminPage(Model model) {
        List<RegisteredAttendeeEntity> attendees = registeredAttendeesRepository.findAll();
        model.addAttribute("title", title);
        model.addAttribute("attendees", attendees);
        return "admin";
    }

    @GetMapping("/edit")
    public String editAttendeeView(@RequestParam Long id, Model model) {
        model.addAttribute("editAttendee", adminService.get(id));
        model.addAttribute("title", title2);
        return "edit-attendee";
    }

    @DeleteMapping("/{id}")
    public String deleteAttendee(@PathVariable Long id) {
        registeredAttendeesRepository.deleteById(id);
        return "redirect:/admin";
    }

    @PostMapping("/edit")
    public String editAttendeeAction(@ModelAttribute("editAttendee")
                                     @Valid RegisteredAttendeeEntity editAttendee,
                                     BindingResult result,
                                     Model model) {

        if (result.hasErrors()) {
            model.addAttribute("title", title2);
            return "edit-attendee";
        }

        adminService.edit(editAttendee);
        return "redirect:/admin";
    }

}
