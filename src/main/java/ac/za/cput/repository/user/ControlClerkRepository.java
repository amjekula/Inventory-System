package ac.za.cput.repository.user;
/*
 *@author @amjekula
 * Description: Interface for Control Clerk Repository
 * Date: 28 August 2020
 */

import ac.za.cput.entity.user.ControlClerk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ControlClerkRepository extends JpaRepository<ControlClerk, String> {

}
