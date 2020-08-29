package ac.za.cput.repository.generic;

import ac.za.cput.entity.generic.University;
import ac.za.cput.repository.IRepository;

import java.util.Set;

public interface UniversityRepository extends IRepository<University,String> {
    Set<University> getAll();
}
