package org.launchcode.techjobs.oo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.Job;
import org.launchcode.techjobs.oo.Employer;
import org.launchcode.techjobs.oo.Location;
import org.launchcode.techjobs.oo.PositionType;
import org.launchcode.techjobs.oo.CoreCompetency;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {
    @Test
    public void testSettingJobId() {
        Job jobOne = new Job();
        Job jobTwo = new Job();
        assertEquals(jobOne.getId(), jobTwo.getId(), 1);
        assertTrue(jobOne.getId() != jobTwo.getId());
        assertFalse(jobOne.getId() == jobTwo.getId());

    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job allFields = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertEquals("Product tester", allFields.getName());
        assertEquals("ACME", allFields.getEmployer().getValue());
        assertEquals("Desert", allFields.getLocation().getValue());
        assertEquals("Quality control", allFields.getPositionType().getValue());
        assertEquals("Persistence", allFields.getCoreCompetency().getValue());
        assertTrue(allFields.getName() instanceof String);
        assertTrue(allFields.getEmployer() instanceof Employer);
        assertTrue(allFields.getLocation() instanceof Location);
        assertTrue(allFields.getPositionType() instanceof PositionType);
        assertTrue(allFields.getCoreCompetency() instanceof CoreCompetency);
    }

    @Test
    public void testJobsForEquality() {
        Job allFieldsOne = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job allFieldsTwo = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertFalse(allFieldsOne.equals(allFieldsTwo));

    }

    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        Job allFields = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertEquals('\n', allFields.toString().charAt(0));
        assertEquals('\n', allFields.toString().charAt(allFields.toString().length() -1));
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        Job allFields = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertEquals("\nID: " + allFields.getId() + "\nName: Product tester\nEmployer: ACME\nLocation: Desert\nPosition Type: Quality control\nCore Competency: Persistence\n", allFields.toString());
    }

    @Test
    public void testToStringHandlesEmptyField() {
        Job noFields = new Job("", new Employer(""), new Location(""), new PositionType(""), new CoreCompetency(""));

        assertEquals("\nID: " + noFields.getId() + "\nName: Data not available\nEmployer: Data not available\nLocation: Data not available\nPosition Type: Data not available\nCore Competency: Data not available\n", noFields.toString());
    }

}
