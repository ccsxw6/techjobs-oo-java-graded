package org.launchcode.techjobs.oo.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import static org.junit.Assert.*;

// Instead of manually creating sample Job objects to verify that your class works correctly, you will use unit tests
/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {
    // Each Job object should have a unique ID that is an integer.
    @Test
    public void testSettingJobId () {
        Job aJob = new Job();
        Job anotherJob = new Job();
        // had to import assertNotEquals for it to work!
        assertNotEquals(aJob.getId(), anotherJob.getId());
    }

    // Job obj should contain 6 fields
    // Use assertTrue and assertEquals statements to test that the constructor correctly assigns both the class and value of each field. Your test should have 5 assert statements of each type.
    @Test
    public void testJobConstructorSetsAllFields(){
        Job aJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertTrue(aJob.getName() instanceof String);
        assertEquals("Product tester", aJob.getName());

        assertTrue(aJob.getEmployer() instanceof Employer);
        // getEmployer() will return an Employer object, which you can then call .getValue() on that employer object
        assertEquals("ACME", aJob.getEmployer().getValue());

        assertTrue(aJob.getLocation() instanceof Location);
        assertEquals("Desert", aJob.getLocation().getValue());

        assertTrue(aJob.getCoreCompetency() instanceof CoreCompetency);
        assertEquals("Persistence", aJob.getCoreCompetency().getValue());
    }

    // We don't actually need this test
    @Test
    public void testJobsForEquality(){
        // Should have same fields but different ids
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job job2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertFalse(job1.equals(job2));
    }

    // Making sure toString ends and begins with \n
    @Test
    public void testToStringStartsAndEndsWithNewLine(){
        Job job = new Job(
                "Web Developer",
                new Employer("LaunchCode"),
                new Location("StL"),
                new PositionType("Back-end developer"),
                new CoreCompetency("Java"));

        char firstChar = job.toString().charAt(0);
        char lastChar = job.toString().charAt(job.toString().length()-1);
        assertEquals(firstChar, '\n');
        assertEquals(lastChar, '\n');
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData(){
        Job job = new Job(
                "Web Developer",
                new Employer("LaunchCode"),
                new Location("StL"),
                new PositionType("Back-end developer"),
                new CoreCompetency("Java"));

        String output = String.format("\nID: %d\n" +
                        "Name: %s\n" +
                        "Employer: %s\n" +
                        "Location: %s\n" +
                        "Position Type: %s\n" +
                        "Core Competency: %s\n",job.getId(), job.getName(), job.getEmployer(), job.getLocation(),
                job.getPositionType(), job.getCoreCompetency());
        assertEquals(output, job.toString());
    }

    @Test
    public void testToStringHandlesEmptyField() {
        Job job = new Job(
                "Web Developer",
                new Employer(""),
                new Location("StL"),
                new PositionType(""),
                new CoreCompetency("Java"));

        String output = String.format("\nID: %d\n" +
                "Name: %s\n" +
                "Employer: Data not available\n" +
                "Location: %s\n" +
                "Position Type: Data not available\n" +
                "Core Competency: %s\n",job.getId(), job.getName(), job.getLocation(), job.getCoreCompetency());

        assertEquals(output, job.toString());
    }


}
