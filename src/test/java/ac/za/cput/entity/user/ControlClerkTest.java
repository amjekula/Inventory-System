package ac.za.cput.entity.user;
/*
 *@author @amjekula
 * Description: Test case for Control Clerk Entity
 * Date: 28 June 2020
 */
import ac.za.cput.entity.user.ControlClerk;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ControlClerkTest {
    ControlClerk controlClerk;

    @Before
    public void setUp() throws Exception {
        controlClerk = new ControlClerk.ControlClerkBuilder().setClerkId("566562").setFirstName("Athenkosi").build();
    }

    @Test
    public void testControlClerk(){
        System.out.println(controlClerk.toString());
    }

    @Test
    public void testUniversityId(){
        assertNull(controlClerk.getUniversity().toString(), null);
    }

}