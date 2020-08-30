package ac.za.cput.entity.user;

import ac.za.cput.entity.user.Login;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
/*
 *@author @joselledina
 * Description: Test Cases for Login
 * Date: 28 June 2020
 */

public class LoginTest {
    Login log;


    @Before
    public void setUp() throws Exception {
         log = new Login.Builder().setLoginId("1256").setEmailAddress("dinos@gmail.com").setPassword(1546).build();
    }

    @Test
    public void getEmail_address() {
        assertNotEquals("dinana@gmail.com",log.getEmailAddress());
        System.out.println("not equal information");
    }

    @Test
    public void getPassword() {
        assertEquals(1546,log.getPassword());
        System.out.println(" equal information");
    }

    @Test
    public void getLoginId() {
        assertEquals("1256",log.getLoginId());
        System.out.println(" equal information");
    }
}