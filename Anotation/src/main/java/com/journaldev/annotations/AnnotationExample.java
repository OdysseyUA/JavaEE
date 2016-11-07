package com.journaldev.annotations;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Odyssey on 07.11.2016.
 */
public class AnnotationExample {

//    public static void main(String[] args) {
//    }

    @Override
    @MethodInfo(author = "bh", comments = "Main method", date = "Nov 07 2016", revision = 1)
    public String toString() {
        return "Overriden toString method";
    }

    @Deprecated
    @MethodInfo(comments = "deprecated method", date = "Nov 07 2016")
    public static void oldMethod() {
        System.out.println("old method, don't use it.");
    }

    @SuppressWarnings({ "unchecked", "deprecation" })
    @MethodInfo(author = "Odyssey", comments = "Main method", date = "Nov 07 2016", revision = 10)
    public static void genericsTest() throws FileNotFoundException {
        List l = new ArrayList();
        l.add("abc");
        oldMethod();
    }
}
