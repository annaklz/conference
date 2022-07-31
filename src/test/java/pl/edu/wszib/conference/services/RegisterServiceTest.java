package pl.edu.wszib.conference.services;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.edu.wszib.conference.entities.RegisteredAttendeeEntity;
import pl.edu.wszib.conference.repositories.RegisteredAttendeesRepository;

import java.util.Collection;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class RegisterServiceTest {

    public static final String FIRSTNAME = "Anna";
    public static final String LASTNAME = "Kluza";
    public static final String AFFILIATION = "WSZIB";
    public static final String CITY = "Krakow";
    public static final String COUNTRY = "Poland";
    public static final String EMAIL = "akluza@student.wszib.edu.pl";
    public static final int NUMBERS_OF_ATTENDEES = 1;


    @Autowired
    RegisteredAttendeesRepository registeredAttendeesRepository;

    @Autowired
    RegisterService registerService;

    @Test
    void testCreate() {
        RegisteredAttendeeEntity newAttendeeEntity = new RegisteredAttendeeEntity(FIRSTNAME, LASTNAME, AFFILIATION, CITY, COUNTRY, EMAIL, new Date(), new Date());
        registerService.create(newAttendeeEntity);
        Collection registeredAttendees = (Collection) registeredAttendeesRepository.findAll();
        assertEquals(NUMBERS_OF_ATTENDEES, registeredAttendees.size(), "Rejestracja nie przebiegła prawidłowo - brak uczestnika");
    }
}