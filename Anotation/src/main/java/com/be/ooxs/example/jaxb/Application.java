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
    private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

    public Group createJavaObjectExample1() {
        Group group = new Group();
        group.setName("Test Group 1");
        try {
            group.getMember().add(createPerson("Alice", "Anderssen", "1970-01-01"));
            group.getMember().add(createPerson("Bert", "Bobo", "1980-02-02"));
        } catch (ParseException exception) {
            Logger.getLogger(Application.class.getName()).
                    log(Level.ALL, "createJavaObjectExample1 threw ParseException", exception);
        }
        return group;
    }

    public Person createPerson(String firstName, String lastName, String birthDate) throws ParseException {
        Person person = new Person();
        person.setBirthDate(format.parse(birthDate));
        person.setFirstName(firstName);
        person.setLastName(lastName);
        return person;
    }

    public void marshallExample() {
        try {
            JAXBContext context = JAXBContext.newInstance(Group.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(createJavaObjectExample1(), System.out);
            marshaller.marshal(createJavaObjectExample1(), new File(FILE_NAME));

        } catch (JAXBException exception) {
            Logger.getLogger(Application.class.getName()).
                    log(Level.SEVERE, "marshallExample threw JAXBException", exception);
        }
    }

    public void unmarshallExample() {
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
            System.out.println("Objects created from XML:");
            System.out.println(groupCopy.getName());
            for (Person person : groupCopy.getMember()) {
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