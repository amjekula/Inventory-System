package ac.za.cput.repository.generic;

import ac.za.cput.entity.generic.University;
import ac.za.cput.repository.IRepository;

import java.util.Set;

/*
 *  @author: Sherwin Adams (216177499)
 *  Desc: University repository
 */

public interface UniversityRepository extends IRepository<University,String> {
    Set<University> getAll();
}
