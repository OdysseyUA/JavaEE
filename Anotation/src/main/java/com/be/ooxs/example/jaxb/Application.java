package com.be.ooxs.example.jaxb;

/**
 * Created by Odyssey on 08.11.2016.
 */
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class Application {
    private static final String FILE_NAME = "jaxb-group.xml";
    private static final String FILE_NAME_PERSON = "jaxb-person.xml";
    private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

    private Group createJavaObjectExample1() {
        Group group = new Group();
        group.setName("Test Group 1");

        group.getMembers().add(createPerson("Alice", "Anderssen", "1970-01-01"));
        group.getMembers().add(createPerson("Bert", "Bobo", "1980-02-02"));

        return group;
    }

    private Person createPerson(String firstName, String lastName, String birthDate)  {
        Person person = new Person();
        try {
            person.setBirthDate(format.parse(birthDate));
            person.setFirstName(firstName);
            person.setLastName(lastName);
        }
        catch (ParseException exception) {
            Logger.getLogger(Application.class.getName()).
                    log(Level.ALL, "createPerson threw ParseException", exception);
        }
        return person;
    }

    private void marshallExample() {
        Group group = createJavaObjectExample1();
        Person person = createPerson("Mark", "Avrely", "1982-02-03");

        try {
            JAXBContext context = JAXBContext.newInstance(Group.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(group, System.out);
            marshaller.marshal(group, new File(FILE_NAME));
            System.out.println();

            marshaller.marshal(person, System.out);
            marshaller.marshal(person, new File(FILE_NAME_PERSON));

        } catch (JAXBException  exception) {
            Logger.getLogger(Application.class.getName()).
                    log(Level.SEVERE, "marshallExample threw JAXBException", exception);
        }
    }

    private void unmarshallExample() {
        try {
            JAXBContext context =
                    JAXBContext.newInstance(Group.class);
            Marshaller marshaller =
                    context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,
                    Boolean.TRUE);

            //write XML to an array of bytes
            ByteArrayOutputStream baos =
                    new ByteArrayOutputStream();
            marshaller.marshal(createJavaObjectExample1(), baos);

            //read XML from array of bytes
            InputStream bais =
                    new ByteArrayInputStream(baos.toByteArray());
            Unmarshaller unmarshaller =
                    context.createUnmarshaller();
            Object o = unmarshaller.unmarshal(bais);

            //prove the Group is recreated
            Group groupCopy = (Group) o;
            System.out.println();
            System.out.println("Objects created from XML:");
            System.out.println(groupCopy.getName());
            for (Person person : groupCopy.getMembers()) {
                System.out.println(person.getFirstName());
            }
        } catch (JAXBException exception) {
            Logger.getLogger(Application.class.getName()).
                    log(Level.SEVERE, "marshallExample threw JAXBException", exception);
        }
    }

    public static void main(String[] args) {
        Application instance = new Application();
        instance.marshallExample();
        instance.unmarshallExample();
        System.out.println("Done");
    }



}