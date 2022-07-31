package pl.edu.wszib.conference.services;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.edu.wszib.conference.entities.RegisteredAttendeeEntity;
import pl.edu.wszib.conference.repositories.RegisteredAttendeesRepository;

import java.util.Date;

@SpringBootTest
class AdminServiceTest {

    public static final String FIRSTNAME = "Anna";
    public static final String FIRSTNAME2 = "Joanna";
    public static final String LASTNAME = "Kluza";
    public static final String AFFILIATION = "WSZIB";
    public static final String CITY = "Krakow";
    public static final String COUNTRY = "Poland";
    public static final String EMAIL = "akluza@student.wszib.edu.pl";
    public static final long ID = 1;

    @Autowired
    RegisteredAttendeesRepository registeredAttendeesRepository;

    @Autowired
    AdminService adminService;

    @Test
    void testGet() {
        RegisteredAttendeeEntity attendeeEntity = new RegisteredAttendeeEntity(FIRSTNAME, LASTNAME, AFFILIATION, CITY, COUNTRY, EMAIL, new Date(), new Date());
        registeredAttendeesRepository.save(attendeeEntity);
        attendeeEntity.equals(adminService.get(ID));
    }

    @Test
    void testEdit() {
        RegisteredAttendeeEntity attendeeEntity = new RegisteredAttendeeEntity(FIRSTNAME, LASTNAME, AFFILIATION, CITY, COUNTRY, EMAIL, new Date(), new Date());
        registeredAttendeesRepository.save(attendeeEntity);
        RegisteredAttendeeEntity editedEntity = new RegisteredAttendeeEntity(attendeeEntity.getId(), FIRSTNAME2, LASTNAME, AFFILIATION, CITY, COUNTRY, EMAIL, attendeeEntity.getRegtime(), new Date());
        adminService.edit(editedEntity);
        adminService.get(ID).equals(editedEntity);
    }
}