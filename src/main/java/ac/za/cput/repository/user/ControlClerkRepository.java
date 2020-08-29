package ac.za.cput.repository.user;
/*
 *@author @amjekula
 * Description: Interface for Control Clerk Repository
 * Date: 28 August 2020
 */

import ac.za.cput.entity.user.ControlClerk;
import ac.za.cput.repository.IRepository;

import java.util.Set;

public interface ControlClerkRepository extends IRepository<ControlClerk, String> {
    Set<ControlClerk> getAll();
}
