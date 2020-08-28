package ac.za.cput.factory.user;
/*
 *@author @joselledina
 * Description: Entity for LoginFactofry
 * Date: 02 July 2020
 */
import ac.za.cput.entity.user.Login;
import ac.za.cput.util.GenericHelper;

public class LoginFactory {
    public static Login createLogin(String emailAddress, int password){
        String loginId = GenericHelper.generateId();
        Login log =new Login.Builder()
                .setLoginId(loginId)
                .setEmailAddress(emailAddress)
                .setPassword(password)
                .build();
        return log;
    }
}
