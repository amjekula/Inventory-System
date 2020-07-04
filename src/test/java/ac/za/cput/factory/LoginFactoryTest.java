package ac.za.cput.factory;
/*
 *@author @joselledina
 * Description: Entity for LoginFactofry
 * Date: 02 July 2020
 */
import ac.za.cput.entity.Login;
import org.junit.Test;

import static org.junit.Assert.*;

public class LoginFactoryTest {

    @Test
    public void createLogin() {
        Login log = LoginFactory.createLogin("josel@gmail.com", 1254);
        System.out.println(log);
    }
}