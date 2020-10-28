package ac.za.cput.controller.generic;


import ac.za.cput.entity.generic.University;
import ac.za.cput.factory.generic.UniversityFactory;
import ac.za.cput.service.generic.impl.UniversityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

/*
 *  @author: Sherwin Adams
 *  Desc: Controller for University
 */

@RestController
@RequestMapping("/university")
public class UniversityController {

    @Autowired
    private UniversityServiceImpl universityService;

    @PostMapping("/create")
    public University create(@RequestBody University university) {
        University newUni = UniversityFactory.createUniversity(university.getName(), university.getAddress());
        return universityService.create(newUni);
    }

    @GetMapping("/all")
    public Set<University> getAll() {
        return universityService.getAll();
    }

    @DeleteMapping("/delete/{universityId}")
    public void delete(@PathVariable String universityId)
    {
        universityService.delete(universityId);
    }

    @PostMapping("/update")
    public University update(@RequestBody University uni){
        return universityService.update(uni);
    }

    @GetMapping("/read/{universityId}")
    public University read(@PathVariable String universityId)
    {
        return universityService.read(universityId);
    }
}
