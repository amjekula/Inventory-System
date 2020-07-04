package ac.za.cput.util;

/*
 *@author @joselledina
 * Description: Entity for LoginFactofry
 * Date: 02 July 2020
 */
import java.util.UUID;

public class GenericHelper {

    public static String generateId()
    {
        return UUID.randomUUID().toString();
    }
}
