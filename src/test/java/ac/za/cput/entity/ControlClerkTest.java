package ac.za.cput.entity;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ControlClerkTest {
    ControlClerk controlClerk;

    @Before
    public void setUp() throws Exception {
        controlClerk = new ControlClerk.ControlClerkBuilder().setClerk_id("566562").setFirstName("Athenkosi").build();
    }

    @Test
    public void testControlClerk(){
        System.out.println(controlClerk.toString());
    }

}