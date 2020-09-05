package ac.za.cput.service.generic;

import ac.za.cput.entity.generic.University;
import ac.za.cput.service.IService;

import java.util.Set;

public interface UniversityService extends IService<University, String> {
    Set<University> getAll();
}
