package ac.za.cput.repository.generic.impl;

import ac.za.cput.entity.generic.University;
import ac.za.cput.repository.generic.UniversityRepository;

import java.util.HashSet;
import java.util.Set;

/*
 *  @author: Sherwin Adams (216177499)
 *  Desc: Implementation for university repository
 */

public class UniversityRepositoryImpl implements UniversityRepository {
    private static UniversityRepository repository = null;
    private Set<University> universityDB;

    private UniversityRepositoryImpl() {
        this.universityDB = new HashSet<>();
    }

    public static UniversityRepository getRepository() {
        if (repository == null) repository = new UniversityRepositoryImpl();
        return  repository;
    }


    @Override
    public Set<University> getAll() {
        return this.universityDB;
    }

    @Override
    public University create(University university) {
        this.universityDB.add(university);
        return university;
    }

    @Override
    public University read(String universityId) {
        University university = this.universityDB
                .stream()
                .filter(l -> l.getUniversityId().equalsIgnoreCase(universityId))
                .findAny()
                .orElse(null);

//        for (University uni : this.universityDB) {
//            if (uni.getUniversityId().equalsIgnoreCase(universityId)) return uni;
//        }

        return university;
    }

    @Override
    public University update(University university) {
        University oldUniversity = read(university.getUniversityId());
        if(oldUniversity != null) {
            this.universityDB.remove(oldUniversity);
            this.universityDB.add(university);
        }
        return university;
    }

    @Override
    public void delete(String universityId) {
        University university = read(universityId);
        if (university != null)
            this.universityDB.remove(university);
    }
}
