package ac.za.cput.service.generic;

import ac.za.cput.entity.generic.University;
import ac.za.cput.service.IService;

import java.util.Set;

/*
 *  @author: Sherwin Adams (216177499)
 *  Desc: University service
 */

public interface UniversityService extends IService<University, String> {
    Set<University> getAll();
}
