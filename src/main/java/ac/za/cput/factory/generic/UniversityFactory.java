package ac.za.cput.factory.generic;

/*
 *  @author: Sherwin Adams
 *  Desc: Factory for University Entity
 */

import ac.za.cput.entity.generic.University;
import ac.za.cput.util.GenericHelper;

public class UniversityFactory {

    public static University createUniversity(String universityName, String address) {
        String universityId = GenericHelper.generateId();
        University university = new University.Builder()
                .setUniversityId(universityId)
                .setName(universityName)
                .setAddress(address)
                .build();
        return university;
    }
}
