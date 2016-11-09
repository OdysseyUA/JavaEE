package com.be.ooxs.example.jaxb;

/**
 * Created by Odyssey on 08.11.2016.
 */
import com.be.ooxs.example.jaxb.extended.PersonType;
import com.be.ooxs.example.jaxb.extended.ShortDateFormatter;
import com.be.ooxs.example.jaxb.extended.Status;

import java.util.Date;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@SuppressWarnings("WeakerAccess")
@XmlRootElement
@XmlType(propOrder = { "firstName", "lastName", "birthDate", "type" }, name = "person")
public class Person {
    private Date birthDate;
    private String firstName;
    private String lastName;
    private PersonType type;
    @XmlAttribute(name = "active")
    private Status status = Status.PENDING_APPROVAL;


    public Person delete() {
        status = Status.INACTIVE;
        return this;
    }

    public Person approve() {
        status = Status.ACTIVE;
        return this;
    }

    @XmlJavaTypeAdapter(ShortDateFormatter.class)
    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
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

    public PersonType getType() {
        return type;
    }

    public void setType(PersonType type) {
        this.type = type;
    }
}
