package ac.za.cput.factory.user;
/*
 * @author @joselledina
 * Description: Entity for LoginFactofry
 * Date: 02 July 2020
 */
import ac.za.cput.entity.user.Login;
import ac.za.cput.factory.user.LoginFactory;
import org.junit.Test;

public class LoginFactoryTest {

    @Test
    public void createLogin() {
        Login log = LoginFactory.createLogin("josel@gmail.com", 1254);
        System.out.println(log);
    }
}