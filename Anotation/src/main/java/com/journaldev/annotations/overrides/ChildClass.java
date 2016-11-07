package com.journaldev.annotations.overrides;

/**
 * Created by Odyssey on 07.11.2016.
 */
public class ChildClass extends BaseClass {

//    @Override
    public void doSomething(String str){
        System.out.println("Child impl: " + str);
    }
}
