package pl.edu.wszib.conference.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.edu.wszib.conference.entities.RegisteredAttendeeEntity;

@Repository
public interface RegisteredAttendeesRepository extends JpaRepository<RegisteredAttendeeEntity, Long> {
}
