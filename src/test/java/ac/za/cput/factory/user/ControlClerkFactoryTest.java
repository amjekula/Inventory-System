package ac.za.cput.factory.user;
/*
 *@author @amjekula
 * Description: Test case for Control Clerk factory
 * Date: 2 June 2020
 */
import ac.za.cput.entity.generic.University;
import ac.za.cput.entity.user.ControlClerk;
import ac.za.cput.factory.generic.UniversityFactory;
import ac.za.cput.factory.user.ControlClerkFactory;
import org.junit.Test;

import static org.junit.Assert.*;

public class ControlClerkFactoryTest {
    ControlClerk controlClerk;

    //When all required arguments have been provided

    private University university = UniversityFactory.createUniversity("cput", "gtvt");

    @Test
    public void testCreateControlClerk(){
        controlClerk = ControlClerkFactory.createControlClerk(university,"Mjekula ", "Athenkosi",
                "0792250655", " ", "46874", "6 Browning Road", "South Africa");
        assertNotNull(controlClerk);

        System.out.println("Test Case 1:\t" + controlClerk + "\n");
    }

    //When some required arguments are not provided
    @Test
    public void testCreateControlClerk2(){
        controlClerk = ControlClerkFactory.createControlClerk(university, " ", "Mjekula",
                " ", "217164692@mycput.ac.za", "246810",
                "6 Varsity Street", "South Africa");
        assertNull(controlClerk);

        System.out.println("Test Case 2:\t" + controlClerk);
    }

}