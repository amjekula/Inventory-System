package ac.za.cput.service.user;
/*
 *@author @amjekula
 * Description: Interface for Control Clerk Service
 * Date: 05 September 2020
 */

import ac.za.cput.entity.user.ControlClerk;
import ac.za.cput.service.IService;

import java.util.Set;

public interface ControlClerkService extends IService <ControlClerk, String>{
    Set<ControlClerk> getAll();
}
