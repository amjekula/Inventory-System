package ac.za.cput.factory;

import ac.za.cput.entity.Login;
import ac.za.cput.util.GenericHelper;

public class LoginFactory {
    public static Login createLogin(String email_address, int password){
        String log_id = GenericHelper.generateId();
        Login log =new Login.Builder()
                .setLogin_id(log_id)
                .setEmail_address(email_address)
                .setPassword(password)
                .build();
        return log;
    }
}
