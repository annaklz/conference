package pl.edu.wszib.conference.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.wszib.conference.entities.RegisteredAttendeeEntity;
import pl.edu.wszib.conference.exception.NotFoundException;
import pl.edu.wszib.conference.repositories.RegisteredAttendeesRepository;


@Service
public class AdminService {

    @Autowired
    private final RegisteredAttendeesRepository attendeesRepository;

    public AdminService(RegisteredAttendeesRepository attendeesRepository) {
        this.attendeesRepository = attendeesRepository;
    }

    public RegisteredAttendeeEntity get(Long id) {
        return attendeesRepository.findById(id).orElseThrow(() -> new NotFoundException());
    }

    public void edit(RegisteredAttendeeEntity editedAttendee) {
        attendeesRepository.save(editedAttendee);
    }

}