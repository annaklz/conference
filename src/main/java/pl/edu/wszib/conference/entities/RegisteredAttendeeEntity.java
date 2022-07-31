package pl.edu.wszib.conference.entities;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "conferenceAttendees")
public class RegisteredAttendeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;
    @Column(name = "first_name")
    @Size(min = 3, max = 30)
    private String firstName;
    @Column(name = "last_name")
    @Size(min = 3, max = 30)
    private String lastName;
    @Column(name = "affiliation")
    @Size(min = 3, max = 30)
    private String affiliation;
    @Column(name = "city")
    @Size(min = 3, max = 30)
    private String city;
    @Column(name = "country")
    @Size(min = 3, max = 30)
    private String country;
    @Size(min = 3, max = 30)
    @Column(name = "email")
    private String email;
    @Column(name = "registration_time", updatable = false)
    @CreationTimestamp
    private Date regtime;
    @Column(name = "update_time")
    @UpdateTimestamp
    private Date updatetime;

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public RegisteredAttendeeEntity() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAffiliation() {
        return affiliation;
    }

    public void setAffiliation(String affiliation) {
        this.affiliation = affiliation;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Date getRegtime() {
        return regtime;
    }

    public void setRegtime(Date regtime) {
        this.regtime = regtime;
    }



}
