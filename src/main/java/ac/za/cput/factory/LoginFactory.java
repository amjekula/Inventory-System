package ac.za.cput.factory;
/*
 *@author @joselledina
 * Description: Entity for LoginFactofry
 * Date: 02 July 2020
 */
import ac.za.cput.entity.Login;
import ac.za.cput.util.GenericHelper;

public class LoginFactory {
    public static Login createLogin(String emailAddress, int password){
        String logId = GenericHelper.generateId();
        Login log =new Login.Builder()
                .setLoginId(logId)
                .setEmail_address(emailAddress)
                .setPassword(password)
                .build();
        return log;
    }
}
