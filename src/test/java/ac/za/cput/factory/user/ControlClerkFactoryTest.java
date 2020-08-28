package ac.za.cput.factory.user;
/*
 *@author @amjekula
 * Description: Test case for Control Clerk factory
 * Date: 2 June 2020
 */
import ac.za.cput.entity.user.ControlClerk;
import ac.za.cput.factory.user.ControlClerkFactory;
import org.junit.Test;

import static org.junit.Assert.*;

public class ControlClerkFactoryTest {
    ControlClerk controlClerk;

    //When all required arguments have been provided
    @Test
    public void testCreateControlClerk(){
        controlClerk = ControlClerkFactory.createControlClerk("Mjekula ", "Athenkosi",
                "0792250655", " ");
        assertNotNull(controlClerk);

        System.out.println("Test Case 1:\t" + controlClerk + "\n");
    }

    //When some required arguments are not provided
    @Test
    public void testCreateControlClerk2(){
        controlClerk = ControlClerkFactory.createControlClerk(" ", "Mjekula",
                " ", "217164692@mycput.ac.za");
        assertNull(controlClerk);

        System.out.println("Test Case 2:\t" + controlClerk);
    }

}