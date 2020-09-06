package ac.za.cput.service.generic.impl;

import ac.za.cput.entity.generic.University;
import ac.za.cput.factory.generic.UniversityFactory;
import ac.za.cput.service.generic.UniversityService;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

import static org.junit.Assert.assertEquals;

/*
 *  @author: Sherwin Adams (216177499)
 *  Desc: Tests for university service implementation
 */

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class UniversityServiceImplTest {

    private static UniversityService service = UniversityServiceImpl.getService();
    private static University university = UniversityFactory.createUniversity("CPUT", "123 Street, Cape Town");

    @Test
    public void d_getAll() {
        Set<University> universitySet = service.getAll();
        assertEquals(1,universitySet.size());
        System.out.println("All Universities: " + universitySet);
    }

    @Test
    public void a_create() {
        University created = service.create(university);
        assertEquals(university.getUniversityId(),created.getUniversityId());
        System.out.println("Created: " + created);
    }

    @Test
    public void b_read() {
        University read = service.read(university.getUniversityId());
        System.out.println("Read: " + read);
    }

    @Test
    public void c_update() {
        University updated = new University.Builder().copy(university).setName("UWC").build();
        updated = service.update(updated);
        System.out.println("Updated: " + updated);
    }

    @Test
    public void e_delete() {
        service.delete(university.getUniversityId());
        assertEquals(0,service.getAll().size());
        System.out.println("Deleted: " + university.getUniversityId());
    }
}