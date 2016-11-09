package com.be.ooxs.example.jaxb;

/**
 * Created by Odyssey on 08.11.2016.
 */
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@SuppressWarnings("WeakerAccess")
@XmlRootElement(name="Person")
@XmlType(propOrder = { "lastName", "firstName", "birthDate" }, name = "person")
public class Person {
    private Date birthDate;
    private String firstName;
    private String lastName;


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

}
