package com.journaldev.annotations.overrides;

/**
 * Created by Odyssey on 07.11.2016.
 */
public class OverrideTest {
    public static void main(String[] args) {
        BaseClass bc = new ChildClass();
        bc.doSomething("override");
    }
}
