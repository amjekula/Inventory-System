package ac.za.cput.service.generic.impl;

import ac.za.cput.entity.equipment.Device;
import ac.za.cput.entity.generic.University;
import ac.za.cput.repository.generic.UniversityRepository;
import ac.za.cput.service.generic.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

/*
 *  @author: Sherwin Adams (216177499)
 *  Desc: Implementation for university service
 */

@Service
public class UniversityServiceImpl implements UniversityService {

    @Autowired
    private UniversityRepository repository;

    @Override
    public Set<University> getAll() {
        return this.repository.findAll().stream().collect(Collectors.toSet());
    }

    @Override
    public University create(University university) {
        return  this.repository.save(university);
    }

    @Override
    public University read(String s) {
        return this.repository.findById(s).orElseGet(null);
    }

    @Override
    public University update(University university) {
        if (this.repository.existsById(university.getUniversityId())) {
            return create(university);
        }
        return null;
    }

    @Override
    public void delete(String s) {
        this.repository.deleteById(s);
    }
}
