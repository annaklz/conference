package pl.edu.wszib.conference.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.wszib.conference.entities.RegisteredAttendeeEntity;
import pl.edu.wszib.conference.repositories.RegisteredAttendeesRepository;

@Service
public class RegisterService {

    @Autowired
    private final RegisteredAttendeesRepository attendeesRepository;

    public RegisterService(RegisteredAttendeesRepository attendeesRepository) {
        this.attendeesRepository = attendeesRepository;
    }

    public void create(RegisteredAttendeeEntity newAttendeeEntity) {
        attendeesRepository.save(newAttendeeEntity);
    }
}