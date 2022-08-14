package org.launchcode.techjobs.oo;

import java.util.Objects;

public class Employer extends JobField{
    // The empty constructor is shared, but not the second constructor. Compiler implicitly calls the default constructor of the superclass
    public Employer(String value){
        // Super is used to give access to methods and properties of a parent or sibling class. Returns an object that represents the parent class
        super(value);
    }

}
