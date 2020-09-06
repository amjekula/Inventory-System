package ac.za.cput.repository.user;

import ac.za.cput.entity.user.Login;
import ac.za.cput.repository.IRepository;

import java.util.Set;
/*
 *@author @joselledina
 * Description: Login repository
 * Date: 25 August 2020
 */

public interface LoginRepository extends IRepository<Login, String> {
Set<Login> getAll();


}