package ac.za.cput.repository.generic;

import ac.za.cput.entity.generic.University;
import ac.za.cput.repository.IRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

/*
 *  @author: Sherwin Adams (216177499)
 *  Desc: University repository
 */

@Repository
public interface UniversityRepository extends JpaRepository<University, String> {
}
