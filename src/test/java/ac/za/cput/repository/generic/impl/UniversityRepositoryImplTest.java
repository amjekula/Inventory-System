package ac.za.cput.repository.generic.impl;

import ac.za.cput.entity.generic.University;
import ac.za.cput.factory.generic.UniversityFactory;
import ac.za.cput.repository.generic.UniversityRepository;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.*;

/*
 *  @author: Sherwin Adams (216177499)
 *  Desc: test implementation for university repository
 */

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UniversityRepositoryImplTest {

    private static UniversityRepository repository = UniversityRepositoryImpl.getRepository();
    private static University university = UniversityFactory.createUniversity("CPUT", "123 street, cape town");

    @Test
    public void d_getAll() {
        System.out.println("Get All: " + repository.getAll());
    }

    @Test
    public void a_create() {
        University created = repository.create(university);
        assertEquals(university.getUniversityId(),created.getUniversityId());
        System.out.println("Created: " + created);
    }

    @Test
    public void b_read() {
        University read = repository.read(university.getUniversityId());
        System.out.println("Read: "+read);
    }

    @Test
    public void c_update() {
        University updated = new University.Builder().copy(university).setName("UWC").build();
        updated = repository.update(updated);
        System.out.println("Updated: " + updated);
    }

    @Test
    public void e_delete() {
        repository.delete(university.getUniversityId());
        assertNotNull(university);
        System.out.println("Deleted: " + university);
    }
}