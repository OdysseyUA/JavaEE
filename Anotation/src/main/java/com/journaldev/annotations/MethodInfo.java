package com.journaldev.annotations;

/**
 * Created by Odyssey on 07.11.2016.
 */

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Target(ElementType.METHOD)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface MethodInfo{
    String author() default "Odyssey";
    String date();
    int revision() default 1;
    String comments();
}