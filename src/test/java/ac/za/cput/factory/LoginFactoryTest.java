package ac.za.cput.factory;

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