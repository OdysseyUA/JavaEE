package com.be.ooxs.example.jaxb;

/**
 * Created by Odyssey on 08.11.2016.
 */
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder = { "name", "member" }, name = "group")
@XmlRootElement
public class Group {
    private String name;
    private List<Person> member = new ArrayList<Person>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Person> getMember() {
        return member;
    }

    public void setMember(List<Person> members) {
        this.member = members;
    }
}