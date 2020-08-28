package ac.za.cput.factory.generic;

import ac.za.cput.entity.generic.University;
import ac.za.cput.factory.generic.UniversityFactory;
import org.junit.Test;

/*
 *  @author: Sherwin Adams
 *  Desc: Tests for University Factory
 */

public class UniversityFactoryTest {

    @Test
    public void createUniversity() {
        University university = UniversityFactory.createUniversity("CPUT", "1 First St, Cape Town");

        System.out.println(university);
    }
}