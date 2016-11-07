package com.journaldev.annotations.overrides;

/**
 * Created by Odyssey on 07.11.2016.
 */
public class BaseClass {

    //Change argument from String to Object
    public void doSomething(String str){
        System.out.println("Base impl: " + str);
    }

}
