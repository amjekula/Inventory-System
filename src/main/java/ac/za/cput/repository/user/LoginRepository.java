package ac.za.cput.repository.user;

import ac.za.cput.entity.user.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;
/*
 *@author @joselledina
 * Description: Login repository
 * Date: 25 August 2020
 */
@Repository
public interface LoginRepository extends JpaRepository<Login, String> {



}