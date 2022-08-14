package org.launchcode.techjobs.oo;

import java.util.Objects;

// Using Object-Oriented rather than storing data in hashmaps and arraylists
public class Job {

    // Used to uniquely identify Job objects
    private int id;
    private static int nextId = 1;

    // Only name is a String! The rest are class typed
    // Every other class has a value and id fields
    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;

    // TODO: Add two constructors - one to initialize a unique ID and a second to initialize the other five fields. The second constructor should also call the first in order to initialize the 'id' field.
    public Job(){
        // why don't we use this here?
        id = nextId;
        nextId++;
    }

    public Job(String name, Employer employer, Location location, PositionType positionType, CoreCompetency coreCompetency){
        this();
        this.name = name;
        this.employer = employer;
        this.location = location;
        this.positionType = positionType;
        this.coreCompetency = coreCompetency;
    }

    // TODO: WRITTEN BY ME - CUSTOM TOSTRING METHOD - TEST FIRST!
    @Override
    public String toString(){
        String output = "";
        if (name.equals("")){
            name = "Data not available";
        }
        if (employer.getValue().equals("") || employer.getValue() == null){
            employer.setValue("Data not available");
        }
        if (location.getValue().equals("") || location.getValue() == null){
            location.setValue("Data not available");
        }
        if (coreCompetency.getValue().equals("") || coreCompetency.getValue() == null){
            coreCompetency.setValue("Data not available");
        }
        if (positionType.getValue().equals("") || positionType.getValue() == null){
            positionType.setValue("Data not available");
        }

        output = String.format("\nID: %d\n" +
                "Name: %s\n" +
                "Employer: %s\n" +
                "Location: %s\n" +
                "Position Type: %s\n" +
                "Core Competency: %s\n", id, name, employer, location, positionType, coreCompetency);
        return output;
    }


    // TODO: Add custom equals and hashCode methods. Consider two Job objects "equal" when their id fields match.
    @Override
    public boolean equals(Object objToBeCompared) {
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
        Job newJob = (Job) objToBeCompared;
        return getId() == newJob.getId();
    }
    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    // TODO: Add getters for each field EXCEPT nextId. Add setters for each field EXCEPT nextID and id.
    public int getId() {
        return id;
    }
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public Employer getEmployer() {return employer;}
    public void setEmployer(Employer employer) {this.employer = employer;}
    public Location getLocation() {return location;}
    public void setLocation(Location location) {this.location = location;}
    public PositionType getPositionType() {return positionType;}
    public void setPositionType(PositionType positionType) {this.positionType = positionType;}
    public CoreCompetency getCoreCompetency() {return coreCompetency;}
    public void setCoreCompetency(CoreCompetency coreCompetency) {this.coreCompetency = coreCompetency;}
}
