package ac.za.cput.service.user;

import ac.za.cput.entity.user.Login;
import ac.za.cput.service.IService;

import java.util.Set;
/*
 *@author @joselleDina
 * Description: Interface for Login Service
 * Date: 01 September 2020
 */

public interface LoginService extends IService<Login, String> {
    Set<Login> getAll();
}
