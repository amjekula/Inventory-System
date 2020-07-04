package ac.za.cput.factory;

import ac.za.cput.entity.University;
import org.junit.Test;

import static org.junit.Assert.*;

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