package ac.za.cput.entity;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import static org.junit.Assert.*;

public class LoginTest {
    Login log;


    @Before
    public void setUp() throws Exception {
         log = new Login.Builder().setEmail_address("dinos@gmail.com").setPassword(1546).build();
    }

    @Test
    public void getEmail_address() {
        assertNotEquals("dinana@gmail.com",log.getEmail_address());
        System.out.println("not equal information");
    }

    @Test
    public void getPassword() {
        assertEquals(1546,log.getPassword());
        System.out.println(" equal information");
    }
}