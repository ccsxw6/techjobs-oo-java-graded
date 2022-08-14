package org.launchcode.techjobs.oo;

import java.util.Objects;

// Abstract class to prevent the creation of a JobField object
public abstract class JobField {
    // What fields do all FOUR classes have in common
    // 1. Employer 2. Location, 3. CoreCompetency 4. PositionType - Not including 5. Job 6. Main
    private int id;
    // Since static, its changing value is NOT stored within any Employer object.
    private static int nextId = 1;
    private String value;

    // Which constructors are same for FOUR classes?
    // Constructor assigns a unique ID number to each new object
    public JobField(){
        this.id = nextId;
        nextId++;
    }
    // Constructor calls the empty constructor in order to initialize the 'id' field and takes a string as a parameter and assigns it to the 'value' field.
    public JobField(String value){
        this();
        this.value = value;
    }

    // What custom methods are identical in ALL classes? just equals? toString is different in Job class...
    // Custom toString() method that returns the data stored in 'value'.
    @Override
    public String toString(){
        return this.value;
    }
    // Custom equals and hashCode methods. Two objects are "equal" when their id fields match.
    public boolean equals(Object objToBeCompared){
        // identical check
        if(objToBeCompared == this){
            return true;
        }
        // null check
        if(objToBeCompared == null){
            return false;
        }
        // type check
        if(objToBeCompared.getClass() != getClass()){
            return false;
        }
        // casting to check to see if, then return true or false if the id of the instantiated object is the same as the id of the object being compared to
        JobField jobField = (JobField) objToBeCompared;
        return getId() == jobField.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    // What getters and setters do ALL classes share? getId, getValue, setValue - different in Job Class
    public int getId() {
        return id;
    }
    public String getValue() {
        return value;
    }
    public void setValue(String value) {
        this.value = value;
    }

}
